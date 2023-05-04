package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {

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
        for (SelenideElement item : searchResultItems) {
            item.shouldHave(text(searchValue));
        }
    }
}
