package PageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$$x;

/**
 * Represents the filters sidebar component.
 */
public class FiltersSidebar {

    private final ElementsCollection departmentsLinks = $$x("//div[@id='departments']//a");

    /**
     * Clicks on the first link under the Departments section in the filters sidebar.
     */
    @Step("Click on Departments first link")
    public void clickOnDepartmentsFirstLink() {
        LogUtils.logInfoMessage("Click on Departments first link");
        departmentsLinks.first().shouldBe(Condition.visible).click();
    }

    /**
     * Retrieves the text of the first link under the Departments section in the filters sidebar.
     *
     * @return The text of the first link.
     */
    @Step("Get Departments first link text")
    public String departmentsFirstLinkGetText() {
        LogUtils.logInfoMessage("Get Departments first link text");
        return departmentsLinks.first().shouldBe(Condition.visible).getText();
    }
}
