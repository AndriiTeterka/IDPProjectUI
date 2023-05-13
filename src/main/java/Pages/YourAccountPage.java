package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$x;

public class YourAccountPage extends BasePage {
    private final SelenideElement yourAddressesLink = $x("//a/div[contains(@data-card-identifier, 'AddressesAnd1Click')]");

    @Step("Click on Your Addresses link")
    public void clickOnYourAddressesLink() {
        LogUtils.logInfoMessage("Click on Your Addresses link");
        yourAddressesLink.shouldBe(Condition.visible).click();
    }
}
