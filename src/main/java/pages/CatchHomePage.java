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

    @FindBy(xpath = "//*[@aria-label= 'Open category menu']")
    private WebElement shop_all_categories_dropdown;

    @FindBy(xpath = "//*[@href= '/shop/onepass']")
    private WebElement onepass_menu;

    @FindBy(xpath = "//h5[text()=\"Today's Deals\"]")
    private WebElement today_deals;

    @FindBy(xpath = "//h5[text()= 'EOFY Sale']")
    private WebElement eofy_sale;

    @FindBy(xpath = "//h5[text()= 'Last Ones Left']")
    private WebElement last_one_left;

    @FindBy(xpath = "//h5[text()='New to Catch']")
    private WebElement new_to_catch;

    @FindBy(xpath = "//h1[text()= 'Shop Top Brands']")
    private WebElement shop_top_brands;

    public CatchHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCatchHomePage(){
        waits.waitForVisibilityOf(catch_logo);
        Assert.assertTrue(catch_logo.isDisplayed());
        Assert.assertTrue(shop_top_brands.isDisplayed());
        Assert.assertTrue(new_to_catch.isEnabled());
        Assert.assertTrue(last_one_left.getText().equals("Last Ones Left"));
        Assert.assertTrue(eofy_sale.isEnabled());
        Assert.assertTrue(onepass_menu.isDisplayed());
        Assert.assertTrue(today_deals.isDisplayed());
        Assert.assertTrue(shop_all_categories_dropdown.isDisplayed());

    }

    public void enterProductToBeSearched() throws InterruptedException {
        waits.waitForVisibilityOf(this.catch_logo);
        Assert.assertTrue(this.search_bar.isEnabled());
        this.search_bar.sendKeys("Biscuit");
        this.search_button.click();
        webBrowserActions.scrollVerticallyByJS(40);
        waits.waitForVisibilityOf(this.product);
        waits.waitForElementToBeClickable(this.product);
        this.product.click();
    }
}

