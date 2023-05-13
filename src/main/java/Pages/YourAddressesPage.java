package Pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.*;

public class YourAddressesPage extends BasePage {
    private final ElementsCollection removeAddressButtons = $$x("//a[contains(@id, 'ya-myab-set-default-shipping-btn')]/../..//a[contains(@id, 'ya-myab-address-delete-btn')]");
    private final SelenideElement confirmModalYesButton = $x("//div[contains(@id, 'a-popover-content')]//span/input");
    private final SelenideElement addressRemovedHeading = $("#yaab-alert-box");

    @Step("Remove all addresses")
    public void removeAllAddresses() {
        LogUtils.logInfoMessage("Remove all addresses");
        try {
            for (int i = 0; i <= removeAddressButtons.size(); i++) {
                removeAddressButtons.get(i).shouldBe(Condition.visible).click();
                confirmModalYesButton.pressTab().pressTab();
                Selenide.sleep(2000);
                confirmModalYesButton.pressEnter();
                addressRemovedHeading.shouldBe(Condition.visible);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Step("Click on confirm modal Yes button")
    public void clickOnConfirmModalYesButton() {
        LogUtils.logInfoMessage("Click on confirm modal Yes button");
        confirmModalYesButton.shouldBe(Condition.visible).click(ClickOptions.usingJavaScript());
    }
}
