package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class HomePage extends BasePage {

    private final ElementsCollection pickupWhereYouLeftItems = $$x("//div[@id='desktop-grid-1']//a//span[contains(@class, 'full')]");

    @Step("Pickup where you left items get titles")
    public List<String> pickupWhereYouLeftItemsGetTitles() {
        LogUtils.logInfoMessage("Pickup where you left items get titles");
        List<String> titles = new ArrayList<>();
        for (SelenideElement title : pickupWhereYouLeftItems) {
            titles.add(title.getOwnText());
        }
        return titles;
    }

    @Step("Is pick up where you left items contains title")
    public boolean isPickupWhereYouLeftItemsContainsTitle(String itemsTitle) {
        LogUtils.logInfoMessage("Is pick up where you left items contains title");
        //TODO
        return pickupWhereYouLeftItems.stream().anyMatch(x -> x.getOwnText().contains(itemsTitle.substring(0, 20)));
    }
}
