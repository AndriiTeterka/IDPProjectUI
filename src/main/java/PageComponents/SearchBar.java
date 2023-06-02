package PageComponents;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.ConfigProvider;
import utils.LogUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

/**
 * Represents the search bar component, which extends the HeaderNavigationBar.
 */
public class SearchBar extends HeaderNavigationBar {

    private final SelenideElement searchBar = $("#twotabsearchtextbox");
    private final SelenideElement searchDropdown = $("#searchDropdownBox");
    private final SelenideElement autocompleteFlyout = $("#nav-flyout-searchAjax");
    private final ElementsCollection autocompleteFlyoutSuggestions = $$x("//div[@class='s-suggestion-container']/div[1]");

    /**
     * Clicks on the search bar.
     */
    @Step("Click on search bar")
    public void clickOnSearchBar() {
        LogUtils.logInfoMessage("Click on search bar");
        searchBar.shouldBe(Condition.visible).click();
    }

    /**
     * Inputs a value into the search bar.
     *
     * @param value The value to be inputted into the search bar.
     */
    @Step("Input value in search bar")
    public void inputValueIntoSearchBar(String value) {
        LogUtils.logInfoMessage("Input value in search bar");
        searchBar.shouldBe(Condition.visible).setValue(value);
        verifyAutocompleteFlyoutSuggestionsAreDisplayed();
    }

    /**
     * Searches for an item using the search bar.
     *
     * @param searchItem The item to search for.
     */
    @Step("Search for item")
    public void searchForItem(String searchItem) {
        LogUtils.logInfoMessage("Search for item");
        searchBar.shouldBe(Condition.visible).setValue(searchItem);
        searchBar.pressEnter();
    }

    /**
     * Verifies if the autocomplete flyout is displayed.
     */
    @Step("Verify autocomplete flyout is displayed")
    public void verifyAutocompleteFlyoutIsDisplayed() {
        LogUtils.logInfoMessage("Verify autocomplete flyout is displayed");
        autocompleteFlyout.shouldBe(Condition.visible);
    }

    /**
     * Verifies if the autocomplete flyout suggestions are displayed.
     */
    @Step("Verify autocomplete flyout suggestions are displayed")
    public void verifyAutocompleteFlyoutSuggestionsAreDisplayed() {
        LogUtils.logInfoMessage("Verify autocomplete flyout suggestions are displayed");
        autocompleteFlyoutSuggestions.shouldHave(CollectionCondition
                .sizeGreaterThanOrEqual(Integer.parseInt(ConfigProvider.SUGGESTIONS_QUANTITY)));
    }

    /**
     * Verifies if all autocomplete flyout suggestions contain the search value.
     *
     * @param searchValue The value to search for in the suggestions.
     */
    @Step("Verify all suggestions contain search value")
    public void verifyAllSuggestionsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify all suggestions contain search value");
        for (SelenideElement suggestion : autocompleteFlyoutSuggestions) {
            suggestion.shouldHave(text(searchValue.toLowerCase()));
        }
    }

    /**
     * Verifies if at least one autocomplete flyout suggestion contains the search value.
     *
     * @param searchValue The value to search for in the suggestions.
     */
    @Step("Verify one of suggestions contain search value")
    public void verifyOneOfSuggestionsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify one of suggestions contain search value");
        autocompleteFlyoutSuggestions.shouldHave(CollectionCondition
                .anyMatch("text", x -> x.getText().contains(searchValue)));
    }

    /**
     * Clicks on the suggestion in the autocomplete flyout by order.
     *
     * @param order The order of the suggestion to click on.
     */
    @Step("Click on suggestion by order")
    public void clickOnSuggestionByOrder(int order) {
        LogUtils.logInfoMessage("Click on suggestion by order");
        if (order >= 0 && order < autocompleteFlyoutSuggestions.size()) {
            autocompleteFlyoutSuggestions.get(order).shouldBe(Condition.visible).click();
        } else {
            autocompleteFlyoutSuggestions.first().shouldBe(Condition.visible).click();
        }
    }

    /**
     * Gets the text of the search bar.
     *
     * @return The text of the search bar.
     */
    @Step("Get Search Bar text")
    public String getSearchBarText() {
        LogUtils.logInfoMessage("Get Search Bar text");
        return searchBar.shouldBe(Condition.visible).getValue();
    }

    /**
     * Gets the text from the selected dropdown option.
     *
     * @return The text from the selected dropdown option.
     */
    @Step("Get text from selected Dropdown option")
    public String searchDropdownSelectedGetText() {
        LogUtils.logInfoMessage("Get text from selected Dropdown option");
        return searchDropdown.getSelectedOptionText();
    }
}