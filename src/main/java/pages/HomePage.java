package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement signInLink = $("#nav-link-accountList");

    @Step("Click on Sign In link")
    public SignInPage clickOnSignInLink() {
        LogUtils.logInfoMessage("Click on Sign In link");
        signInLink.click();
        return new SignInPage();
    }

    @Step("Verify user is signed in")
    public void verifyUserIsSignedIn(String userName) {
        LogUtils.logInfoMessage("Verify user is signed in");
        signInLink.shouldHave(Condition.text(userName));
    }
}
