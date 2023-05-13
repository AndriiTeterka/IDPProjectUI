package Pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.*;

public class ProductCheckoutPage extends BasePage {

    private final SelenideElement phoneNumberInput = $("#address-ui-widgets-enterAddressPhoneNumber");
    private final SelenideElement addressLine1Input = $("#address-ui-widgets-enterAddressLine1");
    private final ElementsCollection addressLine1Suggestions = $$x("//*[@id='address-ui-widgets-enterAddressLine1']/../div//li");
    private final SelenideElement addressLine2Input = $("#address-ui-widgets-enterAddressLine2");
    private final SelenideElement cityInput = $("#address-ui-widgets-enterAddressCity");
    private final SelenideElement stateDropdown = $("#address-ui-widgets-enterAddressStateOrRegion");
    private final ElementsCollection stateDropdownOptions = $$x("//div[@id='a-popover-1']//a[contains(@id, 'address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_')]");
    private final SelenideElement zipCodeInput = $("#address-ui-widgets-enterAddressPostalCode");
    private final SelenideElement useThisAddressButton = $("#address-ui-widgets-form-submit-button");
    private final SelenideElement useThisPaymentButton = $x("//span[contains(text(), 'Use this payment method') and not(@class)]");
    private final SelenideElement homePageLink = $("#banner-image");
    private final SelenideElement returnToCartButton = $x("(//span[@class='a-button-inner']/a[contains(text(), 'Return to Cart')])[2]");
    private final SelenideElement shippingAddressLink = $x("//div[@id='shipaddress']//h3[@data-testid]");
    private final SelenideElement addNewAddressLink = $("#add-new-address-popover-link");

    @Step("Enter phone number")
    public void enterPhoneNumber(String number) {
        LogUtils.logInfoMessage("Enter phone number");
        phoneNumberInput.shouldBe(Condition.visible).setValue(number);
    }

    @Step("Enter address line 1")
    public void enterAddressLine1(String address) {
        LogUtils.logInfoMessage("Enter address line 1");
        addressLine1Input.shouldBe(Condition.visible).setValue(address);
    }

    @Step("Select address line 1 suggestions by order")
    public void selectAddressLine1SuggestionsByOrder(int order) {
        LogUtils.logInfoMessage("Select address line 1 suggestions by order");
        addressLine1Suggestions.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
        addressLine1Suggestions.get(order).shouldBe(Condition.visible).click();
    }

    @Step("Enter address line 2")
    public void enterAddressLine2(String address) {
        LogUtils.logInfoMessage("Enter address line 2");
        addressLine2Input.shouldBe(Condition.visible).setValue(address);
    }

    @Step("Enter city")
    public void enterCity(String city) {
        LogUtils.logInfoMessage("Enter city");
        cityInput.shouldBe(Condition.visible).setValue(city);
    }

    @Step("Click on State dropdown")
    public void clickOnStateDropdown() {
        LogUtils.logInfoMessage("Click on State dropdown");
        stateDropdown.shouldBe(Condition.visible).click();
    }

    @Step("Enter zip code")
    public void enterZipCode(String zipCode) {
        LogUtils.logInfoMessage("Enter zip code");
        zipCodeInput.shouldBe(Condition.visible).setValue(zipCode);
    }

    @Step("Click on Use this address button")
    public void clickOnUseThisAddressButton() {
        LogUtils.logInfoMessage("Click on Use this address button");
        useThisAddressButton.shouldBe(Condition.visible).click();
    }

    @Step("Select state dropdown option by order")
    public void selectStateDropdownOptionByOrder(int order) {
        LogUtils.logInfoMessage("Select state dropdown option by order");
        clickOnStateDropdown();
        stateDropdownOptions.get(order).shouldBe(Condition.visible).click();
    }

    @Step("Verify use this payment button is displayed")
    public void verifyUseThisPaymentButtonIsDisplayed() {
        LogUtils.logInfoMessage("Verify use this payment button is displayed");
        useThisPaymentButton.shouldBe(Condition.visible);
    }

    @Step("Click on home page link")
    public void clickOnHomePageLink() {
        LogUtils.logInfoMessage("Click on home page link");
        homePageLink.shouldBe(Condition.visible).click();
    }

    @Step("Click on Return to Cart button")
    public void clickOnReturnToCartButton() {
        LogUtils.logInfoMessage("Click on Return to Cart button");
        returnToCartButton.shouldBe(Condition.visible).click();
    }

    @Step("Click on shipping address link")
    public void clickOnShippingAddressLink() {
        LogUtils.logInfoMessage("Click on shipping address link");
        shippingAddressLink.shouldBe(Condition.visible).click(ClickOptions.usingJavaScript());
    }

    @Step("Click on add new address link")
    public void clickOnAddNewAddressLink() {
        LogUtils.logInfoMessage("Click on add new address link");
        addNewAddressLink.shouldBe(Condition.visible).click();
    }
}
