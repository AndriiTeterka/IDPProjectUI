package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCheckoutPage {

    private final SelenideElement checkoutHeader = $x("//div[@id='header']/div/div/h1");

    @Step("Verify checkout header text")
    public void verifyCheckoutHeaderText(String text) {
        LogUtils.logInfoMessage("Verify checkout header text");
        checkoutHeader.shouldBe(Condition.and("visible with header text",
                Condition.visible,
                Condition.text(text)));
    }
}
