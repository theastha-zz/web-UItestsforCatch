package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class WebBrowserWaits implements IWait<WebElement>{
    private final WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public WebBrowserWaits(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 5L);
    }

    public WebBrowserWaits(WebDriver driver, int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, (long)timeoutInSeconds);
    }
    public Boolean waitForTitleToBe(String title) {
        return (Boolean)this.wait.until(ExpectedConditions.titleIs(title));
    }
    public Boolean waitForTitleToContain(String title) {
        return (Boolean)this.wait.until(ExpectedConditions.titleContains(title));
    }
    public Boolean waitForUrlToBe(String url) {
        return (Boolean)this.wait.until(ExpectedConditions.urlToBe(url));
    }

    public Boolean waitForUrlToContain(String fraction) {
        return (Boolean)this.wait.until(ExpectedConditions.urlContains(fraction));
    }
    public Boolean waitForUrlToMatch(String regex) {
        return (Boolean)this.wait.until(ExpectedConditions.urlMatches(regex));
    }
    public WebElement waitForVisibilityOf(WebElement element) {
        return (WebElement)this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return (WebElement)this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForRefreshed(ExpectedCondition<WebElement> condition) {
        this.wait.until(ExpectedConditions.refreshed(condition));
    }

    public Boolean waitForElementToBeSelected(WebElement element) {
        return (Boolean)this.wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public Boolean waitForElementToBeSelected(By locator) {
        return (Boolean)this.wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public Alert waitForAlertToBePresent() {
        return (Alert)this.wait.until(ExpectedConditions.alertIsPresent());
    }

    public Object waitForJavaScriptToReturnValue(String javaScript) {
        return this.wait.until(ExpectedConditions.jsReturnsValue(javaScript));
    }
}
