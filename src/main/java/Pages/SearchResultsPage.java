package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage extends BasePage {

    private final SelenideElement searchResultInfoBar = $x("//*[@data-component-type='s-result-info-bar']//span/parent::div");
    private final ElementsCollection searchResultItems = $$x("//div[@data-csa-c-type = 'item']");

    @Step("Verify search result info bar is displayed")
    public void verifySearchResultInfoBarIsDisplayed() {
        LogUtils.logInfoMessage("Verify search result info bar is displayed");
        searchResultInfoBar.shouldBe(Condition.visible);
    }

    @Step("Verify search result info bar contains text")
    public void verifySearchResultInfoBarContainsText(String text) {
        LogUtils.logInfoMessage("Verify search result info bar contains text");
        searchResultInfoBar.shouldHave(text(text));
    }

    @Step("Verify all search result items contain search value")
    public void verifySearchResultItemsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify all search result items contain search value");
        for (int i = 0; i < 10; i++) {
            searchResultItems.get(i).shouldHave(Condition.text(searchValue));
        }
    }

    @Step("Select search result item with price by order")
    public void selectSearchResultItemWithPriceByOrder(int order) {
        LogUtils.logInfoMessage("Select search result item with price by order");
        if (order >= 0 && order < getSearchResultItemsWithPrice().size()) {
            getSearchResultItemsWithPrice().get(order).click();
        } else {
            getSearchResultItemsWithPrice().first().click();
        }
    }

    @Step("Get text of search result item with price by order")
    public String searchResultItemWithPriceByOrderGetText(int order) {
        LogUtils.logInfoMessage("Get text of search result item with price by order");
        if (order >= 0 && order < getSearchResultItemsWithPrice().size()) {
            return getSearchResultItemsWithPrice().get(order).getText();
        } else {
            return getSearchResultItemsWithPrice().first().getText();
        }
    }

    public ElementsCollection getSearchResultItemsWithPrice() {
        return searchResultItems.filterBy(text("$"));
    }
}
