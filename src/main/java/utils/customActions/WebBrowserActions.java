package utils.customActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.support.ui.Select;
import utils.WebBrowserWaits;

import java.time.Duration;
import java.util.List;

public class WebBrowserActions {
    private final WebDriver driver;
    private Actions actions;
    private final WebBrowserWaits waiter;
    private final JavascriptExecutor executor;
    private Action performAction;

    public WebBrowserActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.waiter = new WebBrowserWaits(this.driver);
        this.executor = (JavascriptExecutor)this.driver;
    }

    public WebBrowserActions(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.waiter = new WebBrowserWaits(this.driver, timeoutInSeconds);
        this.executor = (JavascriptExecutor)this.driver;
    }

    public void openUrl(String url) {
        this.driver.navigate().to(url);
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }

    public void navigateForward() {
        this.driver.navigate().forward();
    }

    public WebBrowserActions click(WebElement target) {
        this.actions.click(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions click() {
        this.actions.click();
        return this;
    }

    public WebBrowserActions clickAndHold() {
        this.actions.clickAndHold();
        return this;
    }

    public WebBrowserActions clickAndHold(WebElement target) {
        this.actions.clickAndHold(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions contextClick(WebElement target) {
        this.actions.contextClick(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions contextClick() {
        this.actions.contextClick();
        return this;
    }

    public WebBrowserActions doubleClick() {
        this.actions.doubleClick();
        return this;
    }

    public WebBrowserActions doubleClick(WebElement target) {
        this.actions.doubleClick(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions dragAndDrop(WebElement source, WebElement target) {
        this.actions.dragAndDrop(this.waiter.waitForElementToBeClickable(source), this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        this.actions.dragAndDropBy(this.waiter.waitForElementToBeClickable(source), xOffset, yOffset);
        return this;
    }

    public WebBrowserActions moveByOffset(int xOffset, int yOffset) {
        this.actions.moveByOffset(xOffset, yOffset);
        return this;
    }

    public WebBrowserActions moveToElement(WebElement target) {
        this.actions.moveToElement(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions moveToElement(WebElement target, int xOffset, int yOffset) {
        this.actions.moveToElement(this.waiter.waitForVisibilityOf(target), xOffset, yOffset);
        return this;
    }

    public WebBrowserActions keyDown(CharSequence key) {
        this.actions.keyDown(key);
        return this;
    }

    public WebBrowserActions KeyDown(WebElement target, CharSequence key) {
        this.actions.keyDown(this.waiter.waitForVisibilityOf(target), key);
        return this;
    }

    public WebBrowserActions keyUp(CharSequence key) {
        this.actions.keyUp(key);
        return this;
    }

    public WebBrowserActions keyUp(WebElement target, CharSequence key) {
        this.actions.keyUp(this.waiter.waitForVisibilityOf(target), key);
        return this;
    }

    public WebBrowserActions sendKeys(CharSequence... keys) {
        this.actions.sendKeys(keys);
        return this;
    }

    public WebBrowserActions sendKeys(WebElement target, CharSequence... keys) {
        this.actions.sendKeys(this.waiter.waitForElementToBeClickable(target), keys);
        return this;
    }

    public WebBrowserActions release(WebElement target) {
        this.actions.release(this.waiter.waitForElementToBeClickable(target));
        return this;
    }

    public WebBrowserActions release() {
        this.actions.release();
        return this;
    }

    public WebBrowserActions pause(long pause) {
        this.actions.pause(pause);
        return this;
    }

    public WebBrowserActions pause(Duration duration) {
        this.actions.pause(duration);
        return this;
    }

    public WebBrowserActions tick(Interaction... actions) {
        this.actions.tick(actions);
        return this;
    }

    public WebBrowserActions tick(Action action) {
        this.actions.tick(action);
        return this;
    }

    public void switchToWindow(String windowHandle) {
        this.driver.switchTo().window(windowHandle);
    }



    public void switchToDefaultContent() {
        this.driver.switchTo().defaultContent();
    }

    public void switchToParentFrame() {
        this.driver.switchTo().parentFrame();
    }

    public void switchToAlert() {
        this.waiter.waitForAlertToBePresent();
    }

    public void acceptAlert() {
        this.waiter.waitForAlertToBePresent().accept();
    }

    public void dismissAlert() {
        this.waiter.waitForAlertToBePresent().dismiss();
    }

    public String getAlertText() {
        return this.waiter.waitForAlertToBePresent().getText();
    }

    public void sendAlertText(String text) {
        this.waiter.waitForAlertToBePresent().sendKeys(text);
    }

    public void selectByIndex(WebElement selectElement, int index) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        select.selectByIndex(index);
    }

    public void selectByValue(WebElement selectElement, String value) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        select.selectByValue(value);
    }

    public void selectByVisibleText(WebElement selectElement, String visibleText) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        select.selectByValue(visibleText);
    }

    public List<WebElement> getAllSelectOptions(WebElement selectElement) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        return select.getOptions();
    }

    public List<WebElement> getAllSelectedOptions(WebElement selectElement) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        return select.getAllSelectedOptions();
    }

    public WebElement getFirstSelectedOptions(WebElement selectElement) {
        Select select = new Select(this.waiter.waitForVisibilityOf(selectElement));
        return select.getFirstSelectedOption();
    }

    public void scrollToElementByJS(WebElement element) {
        this.executor.executeScript("arguments[0].scrollIntoView();", new Object[]{element});
    }

    public void scrollToBottomOfPageByJS() {
        this.executor.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
    }

    public void highlightElement(WebElement element) {
        this.executor.executeScript("arguments[0].style.border='3px solid red'", new Object[]{element});
    }

    public void scrollVerticallyByJS(int yPixel) {
        this.executor.executeScript("window.scrollBy(0," + yPixel + ")", new Object[0]);
    }

    public void scrollHorizontallyByJS(int xPixel) {
        this.executor.executeScript("arguments[0].scrollBy(" + xPixel + ",0);", new Object[]{xPixel});
    }

    public Object executeJavascript(String script, Object... args) {
        return this.executor.executeScript(script, args);
    }

    public WebBrowserActions build() {
        this.performAction = this.actions.build();
        return this;
    }

    public void perform() {
        this.build().performAction.perform();
        this.actions = new Actions(this.driver);
    }
}
