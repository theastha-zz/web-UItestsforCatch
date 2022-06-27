package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {

    @FindBy(xpath="//*[@id='form-cart-add']/section[2]/div/div[2]/button")
    private WebElement add_to_cart;

    @FindBy(xpath="//select[@name ='quantity']")
    private WebElement quantity_dropdown;

    @FindBy(xpath = "//*[@id= 'mini-cart']")
    private WebElement mini_cart_button;

    @FindBy(xpath = "//*[@id= 'form-cart-add']/section[2]/div/div[3]")
    private WebElement buy_now_button;

    @FindBy(xpath = "//a[@href='/checkout/payment']")
    private WebElement hover_checkoutlink;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void updateQuantityAddToCard(String quantity){
        webBrowserActions.scrollVerticallyByJS(40);
        waits.waitForVisibilityOf(this.add_to_cart);
        this.quantity_dropdown.click();
        Select dropdown = new Select(this.quantity_dropdown);
        dropdown.selectByValue(quantity);


    }

    public void clickOnBuyNow(){
        webBrowserActions.scrollVerticallyByJS(40);
        Assert.assertTrue(this.buy_now_button.isEnabled());
        webBrowserActions.click(this.buy_now_button);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickOnAddToCart(){
        waits.waitForElementToBeClickable(this.add_to_cart);
        this.add_to_cart.click();
    }

    public  void clickOnMiniCart(){
        waits.waitForElementToBeClickable(this.mini_cart_button);
    }

    public void hoverOnCheckout(){
        webBrowserActions.moveToElement(mini_cart_button);
        waits.waitForVisibilityOf(this.hover_checkoutlink);
        this.hover_checkoutlink.click();
    }

}
