package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * This class represents the search results page in the application.
 * It extends the BasePage class and provides methods to interact with the elements on the page.
 */
public class SearchResultsPage extends BasePage {

    private final SelenideElement searchResultInfoBar = $x("//*[@data-component-type='s-result-info-bar']//span/parent::div");
    private final ElementsCollection searchResultItems = $$x("//div[@data-csa-c-type = 'item']");

    /**
     * Verifies that the search result info bar is displayed.
     */
    @Step("Verify search result info bar is displayed")
    public void verifySearchResultInfoBarIsDisplayed() {
        LogUtils.logInfoMessage("Verify search result info bar is displayed");
        searchResultInfoBar.shouldBe(Condition.visible);
    }

    /**
     * Verifies that the search result info bar contains the specified text.
     *
     * @param text the text to be verified
     */
    @Step("Verify search result info bar contains text")
    public void verifySearchResultInfoBarContainsText(String text) {
        LogUtils.logInfoMessage("Verify search result info bar contains text");
        searchResultInfoBar.shouldHave(text(text));
    }

    /**
     * Verifies that all search result items contain the specified search value.
     *
     * @param searchValue the search value to be verified
     */
    @Step("Verify all search result items contain search value")
    public void verifySearchResultItemsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify all search result items contain search value");
        for (int i = 0; i < 10; i++) {
            searchResultItems.get(i).shouldHave(Condition.text(searchValue));
        }
    }

    /**
     * Selects the search result item with price based on the specified order.
     * If the order is out of range, the first item with price will be selected.
     *
     * @param order the order of the item to be selected
     */
    @Step("Select search result item with price by order")
    public void selectSearchResultItemWithPriceByOrder(int order) {
        LogUtils.logInfoMessage("Select search result item with price by order");
        if (order >= 0 && order < getSearchResultItemsWithPrice().size()) {
            getSearchResultItemsWithPrice().get(order).$x(".//h2/a").shouldBe(visible).click();
        } else {
            getSearchResultItemsWithPrice().first().$x(".//h2/a").shouldBe(visible).click();
        }
    }

    /**
     * Retrieves the text of the search result item with price based on the specified order.
     * If the order is out of range, the text of the first item with price will be retrieved.
     *
     * @param order the order of the item to retrieve the text from
     * @return the text of the search result item
     */
    @Step("Get text of search result item with price by order")
    public String searchResultItemWithPriceByOrderGetText(int order) {
        LogUtils.logInfoMessage("Get text of search result item with price by order");
        if (order >= 0 && order < getSearchResultItemsWithPrice().size()) {
            return getSearchResultItemsWithPrice().get(order).shouldBe(Condition.visible).getText();
        } else {
            return getSearchResultItemsWithPrice().first().shouldBe(Condition.visible).getText();
        }
    }

    /**
     * Retrieves the search result items that have a price.
     *
     * @return the collection of search result items with price
     */
    public ElementsCollection getSearchResultItemsWithPrice() {
        return searchResultItems.filterBy(text("$"));
    }
}
