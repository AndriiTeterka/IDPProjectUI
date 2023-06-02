package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$x;

/**
 This class represents the Your Account page in the application.
 It extends the BasePage class and provides methods to interact with the elements on the page.
 */
public class YourAccountPage extends BasePage {
    private final SelenideElement yourAddressesLink = $x("//a/div[contains(@data-card-identifier, 'AddressesAnd1Click')]");

    /**
     * Clicks on the Your Addresses link.
     */
    @Step("Click on Your Addresses link")
    public void clickOnYourAddressesLink() {
        LogUtils.logInfoMessage("Click on Your Addresses link");
        yourAddressesLink.shouldBe(Condition.visible).click();
    }
}
