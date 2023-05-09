package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductConfirmationPage extends BasePage {

    private final SelenideElement addedProductsDiv = $("#sw-atc-confirmation");
    private final SelenideElement productImage = $("#add-to-cart-confirmation-image");
    private final SelenideElement successMessage = $("#NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    private final SelenideElement cartSubtotal = $x("//div[@id='sw-subtotal']/span/span");
    private final SelenideElement goToCartButton = $x("//*[@id='sw-gtc']//a");
    private final SelenideElement proceedToCheckoutButton = $x("//input[@name='proceedToRetailCheckout']");

    @Step("Verify product confirmation page is displayed")
    public void verifyProductConfirmationPageIsDisplayed() {
        LogUtils.logInfoMessage("Verify product confirmation page is displayed");
        addedProductsDiv.shouldBe(Condition.visible);
    }
    @Step("Verify product image is displayed")
    public void verifyProductImageIsDisplayed() {
        LogUtils.logInfoMessage("Verify product image is displayed");
        productImage.shouldBe(Condition.visible);
    }

    @Step("Verify success message text")
    public void verifySuccessMessageText(String message) {
        LogUtils.logInfoMessage("Verify success message text");
        successMessage.shouldBe(Condition.and("visible with success message",
                Condition.visible,
                Condition.text(message)));
    }

    @Step("Verify cart subtotal price")
    public void verifyCartSubtotalPrice(String price) {
        LogUtils.logInfoMessage("Verify cart subtotal price");
        cartSubtotal.shouldBe(Condition.and("visible with subtotal price",
                Condition.visible,
                Condition.text(price)));
    }

    @Step("Click on Go to Cart button")
    public void clickOnGoToCartButton() {
        LogUtils.logInfoMessage("Click on Go to Cart button");
        goToCartButton.click();
    }

    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton() {
        LogUtils.logInfoMessage("Click on Proceed to Checkout button");
        proceedToCheckoutButton.click();
    }
}
