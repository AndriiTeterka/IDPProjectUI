package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.*;

public class CartFlyout {

    private final SelenideElement cartFlyoutDiv = $("#nav-flyout-ewc");
    private final SelenideElement cartFlyoutDeletedProductDiv = $x("//div[@class='a-section ewc-item-remove-msg']");
    private final SelenideElement cartFlyoutSubtotal = $x("//span[contains(text(), 'Subtotal')]/../following-sibling::div/span");
    private final SelenideElement cartFlyoutGoToCartButton = $x("//div[@id='ewc-compact-actions-container']//a");
    private final SelenideElement cartFlyoutProductLink = $x("//div[@id='ewc-compact-body']//a");
    private final SelenideElement cartFlyoutProductPrice = $x("//div[@id='ewc-compact-body']/div/div/div/div/span");
    private final SelenideElement cartFlyoutProductDeleteButton = $x("//input[@title='Delete']");
    private final SelenideElement cartFlyoutQuantityDropdown = $x("//span[@data-a-class='quantity']");
    private final ElementsCollection cartFlyoutQuantityDropdownOptions = $$x("//div[@id='a-popover-1']//li//input");


    @Step("Verify cart flyout is displayed")
    public void verifyCartFlyoutIsDisplayed() {
        LogUtils.logInfoMessage("Verify cart flyout is displayed");
        cartFlyoutDiv.shouldBe(Condition.visible);
    }

    @Step("Verify cart flyout subtotal price")
    public void verifyCartFlyoutSubtotalPrice(String price) {
        LogUtils.logInfoMessage("Verify cart flyout subtotal price");
        cartFlyoutSubtotal.shouldBe(Condition.and("visible with subtotal price",
                Condition.visible,
                Condition.text(price.substring(0, price.indexOf("\n")))));
    }

    @Step("Click on Cart Flyout Go to Cart button")
    public void clickOnCartFlyoutGoToCartButton() {
        LogUtils.logInfoMessage("Click on Cart Flyout Go to Cart button");
        cartFlyoutGoToCartButton.shouldBe(Condition.visible).click();
    }

    @Step("Click on Cart Flyout product link")
    public void clickOnCartFlyoutProductLink() {
        LogUtils.logInfoMessage("Click on Cart Flyout product link");
        cartFlyoutProductLink.shouldBe(Condition.visible).click();
    }

    @Step("Verify cart flyout product price")
    public void verifyCartFlyoutProductPrice(String price) {
        LogUtils.logInfoMessage("Verify cart flyout product price");
        cartFlyoutProductPrice.shouldBe(Condition.and("visible with product price",
                Condition.visible,
                Condition.text(price.substring(0, price.indexOf("\n")))));
    }

    @Step("Verify cart flyout product removed from cart message")
    public void verifyCartFlyoutProductRemovedFromCartText(String message) {
        LogUtils.logInfoMessage("Verify cart flyout product removed from cart message");
        cartFlyoutDeletedProductDiv.shouldBe(Condition.and("visible with product removed message",
                Condition.visible,
                Condition.text(message)));
    }

    @Step("Click on Cart Flyout product delete button")
    public void clickOnCartFlyoutProductDeleteButton() {
        LogUtils.logInfoMessage("Click on Cart Flyout product delete button");
        cartFlyoutProductDeleteButton.shouldBe(Condition.visible).click();
    }

    @Step("Select cart flyout quantity option")
    public void selectCartFlyoutQuantityOption(int quantityOption) {
        LogUtils.logInfoMessage("Select cart flyout quantity option");
        cartFlyoutQuantityDropdown.shouldBe(Condition.visible).click();
        for (SelenideElement option : cartFlyoutQuantityDropdownOptions) {
            if (option.getValue().equals(String.valueOf(quantityOption))) {
                option.shouldBe(Condition.visible).click();
            }
        }
    }
}
