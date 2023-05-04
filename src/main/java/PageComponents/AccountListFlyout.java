package PageComponents;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$;

public class AccountListFlyout extends HeaderNavigationBar {
    SelenideElement signOutLink = $("#nav-item-signout");

    @Step("Click on Sign Out link")
    public void clickOnSignOutLink() {
        LogUtils.logInfoMessage("Click on Sign Out link");
        signOutLink.click();
    }
}
