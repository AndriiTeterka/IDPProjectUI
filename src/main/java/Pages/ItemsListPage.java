package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$$x;

public class ItemsListPage extends BasePage {

    private final ElementsCollection topRatedItemLinks = $$x("//span[normalize-space() = 'Top rated']/../..//div[@class='a-section octopus-pc-card-content']//span[@class='a-list-item']/div/div/a");

    @Step("Verify top rated items contain title")
    public void verifyTopRatedItemsContainTitle(String title) {
        LogUtils.logInfoMessage("Verify top rated items contain title");
        for (SelenideElement link : topRatedItemLinks) {
            link.shouldHave(Condition.attributeMatching("title", ".*" + title + ".*"));
        }
    }
}
