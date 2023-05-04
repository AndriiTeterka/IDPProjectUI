package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class HeaderNavigationBar {
    private final SelenideElement signInLink = $("#nav-link-accountList");
    private final SelenideElement homePageLogo = $("#nav-logo-sprites");

    @Step("Click on Sign In link")
    public void clickOnSignInLink() {
        LogUtils.logInfoMessage("Click on Sign In link");
        signInLink.click();
    }

    @Step("Hover mouse on Sign In link")
    public void hoverMouseOnSignInLink() {
        LogUtils.logInfoMessage("Hover mouse on Sign In link");
        signInLink.hover();
    }

    @Step("Verify user is signed in")
    public void verifyUserIsSignedIn(String userName) {
        LogUtils.logInfoMessage("Verify user is signed in");
        signInLink.shouldHave(Condition.text(userName));
    }

    @Step("Click on Home Page logo")
    public void clickOnHomePageLogo() {
        LogUtils.logInfoMessage("Click on Home Page logo");
        homePageLogo.click();
    }
}
