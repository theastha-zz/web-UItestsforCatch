package drivermanager.web;

import drivermanager.BrowserInterface;
import drivermanager.config.RunConfiguration;
import drivermanager.config.RunMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WebBrowserManager implements BrowserInterface<WebDriver> {

    private final RunConfiguration configuration;
    private  WebBrowserSessions webBrowserSessions;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebBrowserManager.class.getName());

    public WebBrowserManager() {
        this.configuration = new RunConfiguration();
    }

    public WebDriver getDriver() {
        WebDriver webDriver = null;
        this.webBrowserSessions = new WebBrowserSessions(this.configuration);
        if (this.configuration.getRunMode() == RunMode.LOCAL) {
            webDriver = this.webBrowserSessions.createLocalBrowserSession();
        }
        webDriver.manage().timeouts().implicitlyWait(this.configuration.getImplicitWait(), TimeUnit.SECONDS);
        return webDriver;
    }

    //ToDo to run remote
//    public WebDriver getDriver(DesiredCapabilities capabilities) {

//    }

    public void destroyDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        } else {
            LOGGER.error("Browser is not yet initialized");
        }

    }
}
