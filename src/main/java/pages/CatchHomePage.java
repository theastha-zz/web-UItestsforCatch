package pages;

import drivermanager.web.WebBrowserSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatchHomePage extends BasePage {



    @FindBy(xpath = "//img[@alt='Catch - Screaming Good Deals']")
    private WebElement catch_logo;

    @FindBy(xpath = "//*[@id= 'searchbar']")
    private WebElement search_bar;

    @FindBy(xpath = "//*[@id='primary-header']/div/div/div[1]/div[2]/button")
    private WebElement search_button;


    @FindBy(xpath = "//*[@id= '8164695']")
    private WebElement product;


    public CatchHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCatchHomePage(){
        waits.waitForVisibilityOf(catch_logo);
        Assert.assertTrue(catch_logo.isDisplayed());
    }


    public void enterProductToBeSearched() throws InterruptedException {
        waits.waitForVisibilityOf(this.catch_logo);
        Assert.assertTrue(this.search_bar.isEnabled());
        this.search_bar.sendKeys("Biscuit");
        this.search_button.click();
        waits.waitForVisibilityOf(this.product);
        waits.waitForElementToBeClickable(this.product);
        webBrowserActions.scrollVerticallyByJS(40);
        Thread.sleep(300);
        this.product.click();
    }
}

