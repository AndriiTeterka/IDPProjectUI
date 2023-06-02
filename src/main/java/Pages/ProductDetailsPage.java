package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductDetailsPage extends BasePage {

    private final SelenideElement productTitle = $("#productTitle");
    private final SelenideElement productPrice = $("#corePriceDisplay_desktop_feature_div");
    private final SelenideElement freeDeliveryDate = $("#mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE");
    private final SelenideElement fastestDeliveryDate = $("#mir-layout-DELIVERY_BLOCK-slot-SECONDARY_DELIVERY_MESSAGE_LARGE");
    private final SelenideElement addToCartButton = $("#add-to-cart-button");
    private final SelenideElement buyNowButton = $("#buy-now-button");
    private final SelenideElement warrantyWindow = $x("//div[@id='attach-warranty-display']");
    private final SelenideElement warrantyNoThanksButton = $x("//*[@id='attach-warranty-display']//span[contains(text(), 'No Thanks')]//../input");

    @Step("Get product title text")
    public String getProductTitleText() {
        LogUtils.logInfoMessage("Get product title text");
        return productTitle.shouldBe(Condition.visible).getText();
    }

    @Step("Get product title text")
    public String getProductPriceText() {
        LogUtils.logInfoMessage("Get product price text");
        return productPrice.shouldBe(Condition.visible).getText();
    }

    @Step("Get free delivery date text")
    public String getFreeDeliveryDateText() {
        LogUtils.logInfoMessage("Get free delivery date text");
        String text = freeDeliveryDate.shouldBe(Condition.visible).getText();
        String date = text.substring(text.indexOf("delivery") + 9, text.indexOf("."));
        return date.replaceAll("(\\b\\w{3})\\w+", "$1");
    }

    @Step("Get fastest delivery date text")
    public String getFastestDeliveryDateText() {
        LogUtils.logInfoMessage("Get fastest delivery date text");
        return fastestDeliveryDate.shouldBe(Condition.visible).getText();
    }

    @Step("Click on Add to Cart button")
    public void clickOnAddToCartButton() {
        LogUtils.logInfoMessage("Click on Add to Cart button");
        addToCartButton.shouldBe(Condition.visible).click();
        dismissWarrantyIfDisplayed();
    }

    @Step("Click on Buy Now button")
    public void clickOnBuyNowButton() {
        LogUtils.logInfoMessage("Click on Buy Now button");
        buyNowButton.shouldBe(Condition.visible).click();
    }
    
    public void dismissWarrantyIfDisplayed() {
        LogUtils.logInfoMessage("Dismiss warranty if displayed");
        if (warrantyWindow.isDisplayed()) {
            warrantyNoThanksButton.shouldBe(Condition.visible).click();
        }
    }
}
