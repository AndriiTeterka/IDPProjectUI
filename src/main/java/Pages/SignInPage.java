package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {
    private final SelenideElement emailInput = $("#ap_email");
    private final SelenideElement passwordInput = $("#ap_password");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement signInButton = $("#signInSubmit");
    private final SelenideElement errorMessageBox = $("#auth-error-message-box");
    private final SelenideElement missingEmailAlert = $("#auth-email-missing-alert");
    private final SelenideElement missingPasswordAlert = $("#auth-password-missing-alert");

    @Step("Enter user email")
    public void enterEmail(String email) {
        LogUtils.logInfoMessage("Enter user email");
        emailInput.setValue(email);
    }

    @Step("Enter user password")
    public void enterPassword(String password) {
        LogUtils.logInfoMessage("Enter user password");
        passwordInput.setValue(password);
    }

    @Step("Click on Continue button")
    public void clickOnContinueButton() {
        LogUtils.logInfoMessage("Click on Continue button");
        continueButton.click();
    }

    @Step("Click on Sign In button")
    public void clickOnSignInButton() {
        LogUtils.logInfoMessage("Click on Sign In button");
        signInButton.click();
    }

    @Step("Verify error text")
    public void verifyErrorMessageText(String error) {
        LogUtils.logInfoMessage("Verify error text");
        errorMessageBox.shouldHave(Condition.exactText(error));
    }

    @Step("Verify missing email alert text")
    public void verifyMissingEmailAlertText(String error) {
        LogUtils.logInfoMessage("Verify missing email alert text");
        missingEmailAlert.shouldHave(Condition.exactText(error));
    }

    @Step("Verify missing password alert text")
    public void verifyMissingPasswordAlertText(String error) {
        LogUtils.logInfoMessage("Verify missing password alert text");
        missingPasswordAlert.shouldHave(Condition.exactText(error));
    }
}
