package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$$x;

/**
 This class represents the Items List Page of the application.
 It contains methods to interact with the items list page and perform various actions.
 */
public class ItemsListPage extends BasePage {

    private final ElementsCollection topRatedItemLinks = $$x("//span[normalize-space() = 'Top rated']/../..//div[@class='a-section octopus-pc-card-content']//span[@class='a-list-item']/div/div/a");

    /**
     * Verifies if the top rated items contain the specified title.
     *
     * @param title The title to be verified.
     */
    @Step("Verify top rated items contain title")
    public void verifyTopRatedItemsContainTitle(String title) {
        LogUtils.logInfoMessage("Verify top rated items contain title");
        for (SelenideElement link : topRatedItemLinks) {
            link.shouldHave(Condition.attributeMatching("title", ".*" + title + ".*"));
        }
    }
}
