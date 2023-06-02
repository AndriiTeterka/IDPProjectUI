package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

/**
 * Represents the account list flyout component.
 * Extends the HeaderNavigationBar class.
 */
public class AccountListFlyout extends HeaderNavigationBar {
    private final SelenideElement signOutLink = $("#nav-item-signout");

    /**
     * Clicks on the Sign Out link in the account list flyout.
     * <p>
     * This step is logged and reported in Allure.
     */
    @Step("Click on Sign Out link")
    public void clickOnSignOutLink() {
        LogUtils.logInfoMessage("Click on Sign Out link");
        signOutLink.shouldBe(Condition.visible).click();
    }
}
