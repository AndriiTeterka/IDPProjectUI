package PageComponents;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import utils.LogUtils;

import static com.codeborne.selenide.Selenide.$$x;

public class FiltersSidebar {

    private final ElementsCollection departmentsLinks = $$x("//div[@id='departments']//a");

    @Step("Click on Departments first link")
    public void clickOnDepartmentsFirstLink() {
        LogUtils.logInfoMessage("Click on Departments first link");
        departmentsLinks.first().click();
    }

    @Step("Get Departments first link text")
    public String departmentsFirstLinkGetText() {
        LogUtils.logInfoMessage("Get Departments first link text");
        return departmentsLinks.first().getText();
    }
}
