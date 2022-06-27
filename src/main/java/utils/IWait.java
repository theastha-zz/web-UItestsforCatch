package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public interface IWait<T> {
    Boolean waitForTitleToBe(String var1);

    Boolean waitForTitleToContain(String var1);

    Boolean waitForUrlToBe(String var1);

    Boolean waitForUrlToContain(String var1);

    Boolean waitForUrlToMatch(String var1);

    void waitForRefreshed(ExpectedCondition<T> var1);

    Boolean waitForElementToBeSelected(T var1);

    Boolean waitForElementToBeSelected(By var1);

    Alert waitForAlertToBePresent();

    WebElement waitForElementToBeClickable(WebElement element);

    default void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

}
