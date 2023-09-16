package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

/**
 This class represents the Sign In page in the application.
 It extends the BasePage class and provides methods to interact with the elements on the page.
 */
public class SignInPage extends BasePage {
    private final SelenideElement emailInput = $("#ap_email");
    private final SelenideElement passwordInput = $("#ap_password");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement signInButton = $("#signInSubmit");
    private final SelenideElement errorMessageBox = $("#auth-error-message-box");
    private final SelenideElement missingEmailAlert = $("#auth-email-missing-alert");
    private final SelenideElement missingPasswordAlert = $("#auth-password-missing-alert");

    /**
     * Enters the user's email into the email input field.
     *
     * @param email the user's email
     */
    @Step("Enter user email")
    public void enterEmail(String email) {
        LogUtils.logInfoMessage("Enter user email");
        emailInput.shouldBe(Condition.visible).setValue(email);

    }

    /**
     * Enters the user's password into the password input field.
     *
     * @param password the user's password
     */
    @Step("Enter user password")
    public void enterPassword(String password) {
        LogUtils.logInfoMessage("Enter user password");
        passwordInput.shouldBe(Condition.visible).setValue(password);
    }

    /**
     * Clicks on the Continue button.
     */
    @Step("Click on Continue button")
    public void clickOnContinueButton() {
        LogUtils.logInfoMessage("Click on Continue button");
        continueButton.shouldBe(Condition.visible).click();
    }

    /**
     * Clicks on the Sign In button.
     */
    @Step("Click on Sign In button")
    public void clickOnSignInButton() {
        LogUtils.logInfoMessage("Click on Sign In button");
        signInButton.shouldBe(Condition.visible).click();
    }

    /**
     * Verifies the error message text on the page.
     *
     * @param error the expected error message text
     */
    @Step("Verify error text")
    public void verifyErrorMessageText(String error) {
        LogUtils.logInfoMessage("Verify error text");
        errorMessageBox.shouldHave(Condition.exactText(error));
    }

    /**
     * Verifies the missing email alert text on the page.
     *
     * @param error the expected missing email alert text
     */
    @Step("Verify missing email alert text")
    public void verifyMissingEmailAlertText(String error) {
        LogUtils.logInfoMessage("Verify missing email alert text");
        missingEmailAlert.shouldHave(Condition.exactText(error));
    }

    /**
     * Verifies the missing password alert text on the page.
     *
     * @param error the expected missing password alert text
     */
    @Step("Verify missing password alert text")
    public void verifyMissingPasswordAlertText(String error) {
        LogUtils.logInfoMessage("Verify missing password alert text");
        missingPasswordAlert.shouldHave(Condition.exactText(error));
    }

    /**
     * Signs in an existing user by entering the email, clicking Continue, entering the password, and clicking Sign In.
     *
     * @param email    the user's email
     * @param password the user's password
     */
    @Step("Sign in existing user")
    public void signInExistingUser(String email, String password) {
        LogUtils.logInfoMessage("Sign in existing user");
        enterEmail(email);
        clickOnContinueButton();
        enterPassword(password);
        clickOnSignInButton();
    }
}
