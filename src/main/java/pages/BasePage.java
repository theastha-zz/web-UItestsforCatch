package pages;

import module.CatchObjects;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;
import utils.WebBrowserWaits;
import utils.customActions.WebBrowserActions;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebBrowserWaits waits;
    protected WebBrowserWaits longWaits;
    protected WebBrowserActions webBrowserActions;
//    protected WebElementMethods elementMethods;

    protected PropertyReader propertyReader;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waits = new WebBrowserWaits(this.driver, 10);
        longWaits= new WebBrowserWaits(this.driver, 30);
        webBrowserActions = new WebBrowserActions(driver, 10);

    }





}

