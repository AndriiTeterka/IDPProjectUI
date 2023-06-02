package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.*;

/**
 This class represents the Cart Page of the application.
 It contains methods to interact with the cart and perform various actions.
 */
public class CartPage extends BasePage {

    private final ElementsCollection addedProductTitles = $$x("//span[@class='a-list-item']/a/span/span");
    private final ElementsCollection addedProductPrices = $$x("//div[@class='sc-item-content-group']//p");
    private final SelenideElement addedProductSubtotal = $("#sc-subtotal-amount-activecart");
    private final SelenideElement proceedToCheckoutButton = $("#sc-buy-box-ptc-button");
    private final ElementsCollection addedProductsDeleteLink = $$x("//span[@data-feature-id='delete']//input");
    private final SelenideElement emptyCartHeading = $x("//div[@id='sc-active-cart']//h1[@class]");
    private final SelenideElement itemRemovedFromCartMessage = $x("//form[@id='activeCartViewForm']//div[@class='sc-list-item-removed-msg']");

    /**
     * Verifies if the added products' titles contain the specified text.
     *
     * @param text The text to be verified.
     * @return {@code true} if the text is found in the titles of the added products, {@code false} otherwise.
     */
    @Step("Verify added products title contains text")
    public boolean isAddedProductsTitleContainsText(String text) {
        LogUtils.logInfoMessage("Verify added products title contains text");
        for (SelenideElement title : addedProductTitles) {
            if (text.contains(title.shouldBe(Condition.visible)
                    .getText()
                    .replaceAll("\\…", ""))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies if the added products' prices contain the specified text.
     *
     * @param text The text to be verified.
     * @return {@code true} if the text is found in the prices of the added products, {@code false} otherwise.
     */
    @Step("Verify added products price contains text")
    public boolean isAddedProductsPriceContainsText(String text) {
        LogUtils.logInfoMessage("Verify added products price contains text");
        for (SelenideElement price : addedProductPrices) {
            if (text.contains(price.shouldBe(Condition.visible)
                    .getText()
                    .substring(0, price.getText().indexOf('.')))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the subtotal of the added products.
     *
     * @return The subtotal as a double value.
     */
    @Step("Calculate added products subtotal")
    public double calculateAddedProductsSubtotal() {
        LogUtils.logInfoMessage("Calculate added products subtotal");
        double subtotal = 0;
        for (SelenideElement price : addedProductPrices) {
            subtotal += Double.parseDouble(price.shouldBe(Condition.visible)
                    .getText()
                    .substring(price.getText().indexOf('$') + 1)
                    .replaceAll("\\,", ""));
        }
        return subtotal;
    }

    /**
     * Gets the subtotal of the added products as a double value.
     *
     * @return The subtotal as a double value.
     */
    @Step("Get added products subtotal as double")
    public double getAddedProductsSubtotalAsDouble() {
        LogUtils.logInfoMessage("Verify added products price contains text");
        String subtotal = addedProductSubtotal.shouldBe(Condition.visible).getText();
        return Double.parseDouble(subtotal.substring(subtotal.indexOf('$') + 1)
                .replaceAll("\\,", ""));
    }

    /**
     * Clicks on the Proceed to Checkout button.
     */
    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton() {
        LogUtils.logInfoMessage("Click on Proceed to Checkout button");
        proceedToCheckoutButton.shouldBe(Condition.visible).click();
    }

    /**
     * Removes all items from the cart.
     */
    @Step("Remove all items from cart")
    public void removeAllItemsFromCart() {
        LogUtils.logInfoMessage("Remove all items from cart");
        while (addedProductsDeleteLink.size() > 0) {
            addedProductsDeleteLink.first().shouldBe(Condition.visible).click();
            itemRemovedFromCartMessage.shouldBe(Condition.visible);
            //TODO
            Selenide.sleep(1000);
        }
        emptyCartHeading.shouldBe(Condition.visible);
    }
}
