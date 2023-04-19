package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private final SelenideElement emailInput = $("#ap_email");
    private final SelenideElement passwordInput = $("#ap_password");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement signInButton = $("#signInSubmit");
    private final SelenideElement errorMessageBox = $("#auth-error-message-box");

    @Step("Enter user email")
    public SignInPage enterEmail(String email) {
        LogUtils.logInfoMessage("Enter user email");
        emailInput.setValue(email);
        return this;
    }

    @Step("Enter user password")
    public SignInPage enterPassword(String password) {
        LogUtils.logInfoMessage("Enter user password");
        passwordInput.setValue(password);
        return this;
    }

    @Step("Click on Continue button")
    public SignInPage clickOnContinueButton() {
        LogUtils.logInfoMessage("Click on Continue button");
        continueButton.click();
        return this;
    }

    @Step("Press ENTER on Sign In button")
    public SignInPage pressEnterOnSignInButton() {
        LogUtils.logInfoMessage("Press ENTER on Sign In button");
        signInButton.pressEnter();
        return this;
    }

    @Step("Click on Sign In button")
    public HomePage clickOnSignInButton() {
        LogUtils.logInfoMessage("Click on Sign In button");
        signInButton.click();
        return new HomePage();
    }

    @Step("Verify error text")
    public void verifyErrorText(String error) {
        LogUtils.logInfoMessage("Verify error text");
        errorMessageBox.shouldHave(Condition.exactText(error));
    }
}
