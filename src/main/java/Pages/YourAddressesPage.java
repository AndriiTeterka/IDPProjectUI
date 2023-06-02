package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.*;

/**
 This class represents the Your Addresses page in the application.
 It extends the BasePage class and provides methods to interact with the elements on the page.
 */
public class YourAddressesPage extends BasePage {
    private final ElementsCollection removeAddressButtons = $$x("//a[contains(@id, 'ya-myab-set-default-shipping-btn')]/../..//a[contains(@id, 'ya-myab-address-delete-btn')]");
    private final SelenideElement confirmModalYesButton = $x("//div[contains(@id, 'a-popover-content')]//span/input");
    private final SelenideElement addressRemovedHeading = $("#yaab-alert-box");

    /**
     * Removes all addresses from the Your Addresses page.
     * Waits for a confirmation modal dialog and verifies the successful removal of each address.
     */
    @Step("Remove all addresses")
    public void removeAllAddresses() {
        LogUtils.logInfoMessage("Remove all addresses");
        while (removeAddressButtons.size() > 0) {
            removeAddressButtons.first().shouldBe(Condition.visible).click();
            //TODO
            Selenide.sleep(1000);
            confirmModalYesButton.doubleClick();
            addressRemovedHeading.shouldBe(Condition.visible);
        }
    }
}
