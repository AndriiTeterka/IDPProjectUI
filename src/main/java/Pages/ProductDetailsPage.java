package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage extends BasePage {

    private final SelenideElement productTitle = $("#productTitle");
    private final SelenideElement productPrice = $("#corePriceDisplay_desktop_feature_div");
    private final SelenideElement freeDeliveryDate = $("#mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE");
    private final SelenideElement fastestDeliveryDate = $("#mir-layout-DELIVERY_BLOCK-slot-SECONDARY_DELIVERY_MESSAGE_LARGE");
    private final SelenideElement addToCartButton = $("#add-to-cart-button");

    @Step("Get product title text")
    public String getProductTitleText() {
        LogUtils.logInfoMessage("Get product title text");
        return productTitle.getText();
    }

    @Step("Get product title text")
    public String getProductPriceText() {
        LogUtils.logInfoMessage("Get product price text");
        return productPrice.getText();
    }

    @Step("Get free delivery date text")
    public String getFreeDeliveryDateText() {
        LogUtils.logInfoMessage("Get free delivery date text");
        String text = freeDeliveryDate.getText();
        String date = text.substring(text.indexOf("delivery") + 9, text.indexOf("."));
        return date.replaceAll("(\\b\\w{3})\\w+", "$1");
    }

    @Step("Get fastest delivery date text")
    public String getFastestDeliveryDateText() {
        LogUtils.logInfoMessage("Get fastest delivery date text");
        return fastestDeliveryDate.getText();
    }

    @Step("Click on Add to Cart button")
    public void clickOnAddToCartButton() {
        LogUtils.logInfoMessage("Click on Add to Cart button");
        addToCartButton.click();
    }
}
