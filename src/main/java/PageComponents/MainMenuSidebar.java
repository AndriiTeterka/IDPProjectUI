package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.ConfigProvider;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Represents the main menu sidebar component, which extends the HeaderNavigationBar.
 */
public class MainMenuSidebar extends HeaderNavigationBar {

    private final SelenideElement computersLink = $x("//a[@class='hmenu-item']/div[contains(text(), '" + ConfigProvider.COMPUTERS_CATEGORY + "')]");
    private final SelenideElement monitorsLink = $x("//a[@class='hmenu-item'][contains(text(), '" + ConfigProvider.MONITORS_CATEGORY + "')]");
    private final ElementsCollection seeAllLinks = $$x("//a[@class='hmenu-item hmenu-compressed-btn']");

    /**
     * Clicks on the Computers link in the main menu sidebar.
     */
    @Step("Click on computers link")
    public void clickOnComputersLink() {
        LogUtils.logInfoMessage("Click on computers link");
        expandAllCategories();
        computersLink.shouldBe(Condition.visible).click();
    }

    /**
     * Clicks on the Monitors link in the main menu sidebar.
     */
    @Step("Click on monitors link")
    public void clickOnMonitorsLink() {
        LogUtils.logInfoMessage("Click on monitors link");
        monitorsLink.shouldBe(Condition.visible).click();
    }

    /**
     * Expands all categories in the main menu sidebar.
     */
    @Step("Expand all categories")
    public void expandAllCategories() {
        LogUtils.logInfoMessage("Expand all categories");
        for (SelenideElement link : seeAllLinks) {
            link.shouldBe(Condition.visible).click();
        }
    }
}
