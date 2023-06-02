package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 The ProductConfirmationPage class represents the page object for the product confirmation page.
 It contains methods to perform actions and validations on the page elements.
 */
public class ProductConfirmationPage extends BasePage {

    private final SelenideElement addedProductsDiv = $("#sw-atc-confirmation");
    private final SelenideElement productImage = $("#add-to-cart-confirmation-image");
    private final SelenideElement successMessage = $("#NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    private final SelenideElement cartSubtotal = $x("//div[@id='sw-subtotal']/span/span");
    private final SelenideElement goToCartButton = $x("//*[@id='sw-gtc']//a");
    private final SelenideElement proceedToCheckoutButton = $x("//input[@name='proceedToRetailCheckout']");

    /**
     * Verifies that the product confirmation page is displayed.
     */
    @Step("Verify product confirmation page is displayed")
    public void verifyProductConfirmationPageIsDisplayed() {
        LogUtils.logInfoMessage("Verify product confirmation page is displayed");
        addedProductsDiv.shouldBe(Condition.visible);
    }

    /**
     * Verifies that the product image is displayed.
     */
    @Step("Verify product image is displayed")
    public void verifyProductImageIsDisplayed() {
        LogUtils.logInfoMessage("Verify product image is displayed");
        productImage.shouldBe(Condition.visible);
    }

    /**
     * Verifies the success message text on the page.
     *
     * @param message the expected success message text
     */
    @Step("Verify success message text")
    public void verifySuccessMessageText(String message) {
        LogUtils.logInfoMessage("Verify success message text");
        successMessage.shouldBe(Condition.and("visible with success message",
                Condition.visible,
                Condition.text(message)));
    }

    /**
     * Verifies the cart subtotal price on the page.
     *
     * @param price the expected cart subtotal price
     */
    @Step("Verify cart subtotal price")
    public void verifyCartSubtotalPrice(String price) {
        LogUtils.logInfoMessage("Verify cart subtotal price");
        cartSubtotal.shouldBe(Condition.and("visible with subtotal price",
                Condition.visible,
                Condition.text(price)));
    }

    /**
     * Clicks on the "Go to Cart" button.
     */
    @Step("Click on Go to Cart button")
    public void clickOnGoToCartButton() {
        LogUtils.logInfoMessage("Click on Go to Cart button");
        goToCartButton.shouldBe(Condition.visible).click();
    }

    /**
     * Clicks on the "Proceed to Checkout" button.
     */
    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton() {
        LogUtils.logInfoMessage("Click on Proceed to Checkout button");
        proceedToCheckoutButton.shouldBe(Condition.visible).click();
    }
}
