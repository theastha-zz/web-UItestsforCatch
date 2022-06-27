import drivermanager.BrowserInterface;
import drivermanager.config.RunConfiguration;
import drivermanager.web.WebBrowserManager;
import module.CatchObjects;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

import java.lang.reflect.Method;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static final String PROPERTY_FILE_LOCATION = "catch.properties";

    protected static ThreadLocal<CatchObjects> catchObjectsThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<>();
    private static BrowserInterface<WebDriver> browserInterface;
    protected PropertyReader propertyReader;

    @BeforeSuite(alwaysRun = true)
    public void setup(ITestContext context) {
        String path = System.getProperty("config");
        RunConfiguration configuration = new RunConfiguration();
        browserInterface = new WebBrowserManager();

    }

    @BeforeMethod
    public void init(Method method) {
        propertyReader = new PropertyReader(PROPERTY_FILE_LOCATION);
        driverlocal.set(browserInterface.getDriver());
        catchObjectsThreadLocal.set(new CatchObjects(driverlocal.get()));
        catchObjectsThreadLocal.get().visit();
    }

    @AfterMethod(alwaysRun = true)
    public void destroy(ITestResult result) {
        browserInterface.destroyDriver(driverlocal.get());
        catchObjectsThreadLocal.remove();
        driverlocal.remove();
    }
}
