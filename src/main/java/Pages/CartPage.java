package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class CartPage extends BasePage {

    private final ElementsCollection addedProductTitles = $$x("//span[@class='a-list-item']/a/span/span");
    private final ElementsCollection addedProductPrices = $$x("//div[@class='sc-item-content-group']//p");
    private final SelenideElement addedProductSubtotal = $("#sc-subtotal-amount-activecart");
    private final SelenideElement proceedToCheckoutButton = $("#sc-buy-box-ptc-button");

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

    @Step("Get added products subtotal as double")
    public double getAddedProductsSubtotalAsDouble() {
        LogUtils.logInfoMessage("Verify added products price contains text");
        String subtotal = addedProductSubtotal.shouldBe(Condition.visible).getText();
        return Double.parseDouble(subtotal.substring(subtotal.indexOf('$') + 1)
                .replaceAll("\\,", ""));
    }

    @Step("Click on Proceed to Checkout button")
    public void clickOnProceedToCheckoutButton() {
        LogUtils.logInfoMessage("Click on Proceed to Checkout button");
        proceedToCheckoutButton.shouldBe(Condition.visible).click();
    }
}
