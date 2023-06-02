package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

/**
 This class represents the Home Page of the application.
 It contains methods to interact with the home page and perform various actions.
 */
public class HomePage extends BasePage {

    private final ElementsCollection pickupWhereYouLeftItems = $$x("//div[@id='desktop-grid-1']//a//span[contains(@class, 'full')]");

    /**
     * Retrieves the titles of the "Pickup where you left" items.
     *
     * @return A list of titles as strings.
     */
    @Step("Pickup where you left items get titles")
    public List<String> pickupWhereYouLeftItemsGetTitles() {
        LogUtils.logInfoMessage("Pickup where you left items get titles");
        List<String> titles = new ArrayList<>();
        for (SelenideElement title : pickupWhereYouLeftItems) {
            titles.add(title.getOwnText());
        }
        return titles;
    }

    /**
     * Checks if the "Pickup where you left" items contain the specified title.
     *
     * @param itemsTitle The title to be checked.
     * @return {@code true} if the items contain the title, {@code false} otherwise.
     */
    @Step("Is pick up where you left items contains title")
    public boolean isPickupWhereYouLeftItemsContainsTitle(String itemsTitle) {
        LogUtils.logInfoMessage("Is pick up where you left items contains title");
        //TODO
        return pickupWhereYouLeftItems.stream().anyMatch(x -> x.getOwnText().contains(itemsTitle.substring(0, 20)));
    }
}
