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

public class SearchBar extends HeaderNavigationBar {

    private final SelenideElement searchBar = $("#twotabsearchtextbox");
    private final SelenideElement searchDropdown = $("#searchDropdownBox");
    private final SelenideElement autocompleteFlyout = $("#nav-flyout-searchAjax");
    private final ElementsCollection autocompleteFlyoutSuggestions = $$x("//div[@class='s-suggestion-container']/div[1]");

    @Step("Click on search bar")
    public void clickOnSearchBar() {
        LogUtils.logInfoMessage("Click on search bar");
        searchBar.click();
    }

    @Step("Input value in search bar")
    public void inputValueIntoSearchBar(String value) {
        LogUtils.logInfoMessage("Input value in search bar");
        searchBar.setValue(value);
        verifyAutocompleteFlyoutSuggestionsAreDisplayed();
    }

    @Step("Search for item")
    public void searchForItem(String searchItem) {
        LogUtils.logInfoMessage("Search for item");
        searchBar.setValue(searchItem);
        searchBar.pressEnter();
    }

    @Step("Verify autocomplete flyout is displayed")
    public void verifyAutocompleteFlyoutIsDisplayed() {
        LogUtils.logInfoMessage("Verify autocomplete flyout is displayed");
        autocompleteFlyout.shouldBe(Condition.visible);
    }

    @Step("Verify autocomplete flyout suggestions are displayed")
    public void verifyAutocompleteFlyoutSuggestionsAreDisplayed() {
        LogUtils.logInfoMessage("Verify autocomplete flyout suggestions are displayed");
        autocompleteFlyoutSuggestions.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(Integer.parseInt(ConfigProvider.SUGGESTIONS_QUANTITY)));
    }

    @Step("Verify all suggestions contain search value")
    public void verifyAllSuggestionsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify all suggestions contain search value");
        for (SelenideElement suggestion : autocompleteFlyoutSuggestions) {
            suggestion.shouldHave(text(searchValue.toLowerCase()));
        }
    }

    @Step("Verify one of suggestions contain search value")
    public void verifyOneOfSuggestionsContainSearchValue(String searchValue) {
        LogUtils.logInfoMessage("Verify one of suggestions contain search value");
        autocompleteFlyoutSuggestions.shouldHave(CollectionCondition.anyMatch("text", x -> x.getText().contains(searchValue)));
    }

    @Step("Click on suggestion by order")
    public void clickOnSuggestionByOrder(int order) {
        LogUtils.logInfoMessage("Click on suggestion by order");
        if (order >= 0 && order < autocompleteFlyoutSuggestions.size()) {
            autocompleteFlyoutSuggestions.get(order).click();
        } else {
            autocompleteFlyoutSuggestions.first().click();
        }
    }

    @Step("Get Search Bar text")
    public String getSearchBarText() {
        LogUtils.logInfoMessage("Get Search Bar text");
        return searchBar.getValue();
    }

    @Step("Get text from selected Dropdown option")
    public String searchDropdownSelectedGetText() {
        LogUtils.logInfoMessage("Get text from selected Dropdown option");
        return searchDropdown.getSelectedOptionText();
    }
}