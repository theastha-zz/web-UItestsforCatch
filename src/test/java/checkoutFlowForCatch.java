
import org.testng.annotations.Test;

public class checkoutFlowForCatch extends BaseTest {

    @Test(groups="Test")
    public void verifyUserIsAbleToOpenURL(){
        catchObjectsThreadLocal.get().catchHomePage.verifyCatchHomePage();
    }

    @Test(groups="Test")
    public void verifySearchForTheProduct() throws InterruptedException {
        catchObjectsThreadLocal.get().catchHomePage.enterProductToBeSearched();
        catchObjectsThreadLocal.get().productDetailPage.updateQuantityAddToCard("4");
    }

    @Test(groups="Test")
    public void verifyOrderNowFlow() throws InterruptedException {
        catchObjectsThreadLocal.get().catchHomePage.enterProductToBeSearched();
        catchObjectsThreadLocal.get().productDetailPage.updateQuantityAddToCard("4");
        catchObjectsThreadLocal.get().productDetailPage.clickOnBuyNow();
        catchObjectsThreadLocal.get().checkoutPage.verifyCheckoutFlow();

    }
}
