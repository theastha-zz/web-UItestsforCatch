package module;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.CatchHomePage;
import pages.CheckoutPage;
import pages.ProductDetailPage;
import utils.PropertyReader;

public class CatchObjects {
    private static final String propertyFile = "catch.properties";
    public final CatchHomePage catchHomePage;
    public final ProductDetailPage productDetailPage;
    public  final CheckoutPage checkoutPage;
    protected final PropertyReader propertyReader;
    private final WebDriver driver;

    @Getter
    private final String url;

    public CatchObjects(WebDriver driver) {
        this.driver = driver;
        this.propertyReader = new PropertyReader(propertyFile);
        this.catchHomePage =  new CatchHomePage(this.driver);
        this.productDetailPage = new ProductDetailPage(this.driver);
        this.checkoutPage = new CheckoutPage(this.driver);
        this.url = propertyReader.getProperty("url");

    }

    public void visit() {
        driver.navigate().to(getUrl());
    }
}
