package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class HeaderNavigationBar {
    private final SelenideElement accountListLink = $("#nav-link-accountList");
    private final SelenideElement homePageLogo = $("#nav-logo-sprites");
    private final SelenideElement cartButton = $("#nav-cart");
    private final SelenideElement cartButtonCounter = $("#nav-cart-count");
    private final SelenideElement hamburgerMenuButton = $("#nav-hamburger-menu");

    @Step("Click on Account List link")
    public void clickOnAccountListLink() {
        LogUtils.logInfoMessage("Click on Account List link");
        accountListLink.shouldBe(Condition.visible).click();
    }

    @Step("Hover mouse on Sign In link")
    public void hoverMouseOnSignInLink() {
        LogUtils.logInfoMessage("Hover mouse on Sign In link");
        accountListLink.shouldBe(Condition.visible).hover();
    }

    @Step("Verify user is signed in")
    public void verifyUserIsSignedIn(String userName) {
        LogUtils.logInfoMessage("Verify user is signed in");
        accountListLink.shouldHave(Condition.text(userName));
    }

    @Step("Click on Home Page logo")
    public void clickOnHomePageLogo() {
        LogUtils.logInfoMessage("Click on Home Page logo");
        homePageLogo.shouldBe(Condition.visible).click();
    }

    @Step("Click on Cart button")
    public void clickOnCartButton() {
        LogUtils.logInfoMessage("Click on Cart button");
        cartButton.shouldBe(Condition.visible).click();
        ;
    }

    @Step("Verify Cart button counter text")
    public void verifyCarButtonCounterText(String text) {
        LogUtils.logInfoMessage("Verify Cart button counter text");
        cartButtonCounter.shouldHave(Condition.text(text));
    }

    @Step("Click on hamburger menu button")
    public void clickOnHamburgerMenuButton() {
        LogUtils.logInfoMessage("Click on hamburger menu button");
        hamburgerMenuButton.shouldBe(Condition.visible).click();
    }
}
