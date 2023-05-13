package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

    public String getPageTitle() {
        return Selenide.title();
    }

    public void pressBack(int amount) {
        int count = 1;
        while (count <= amount) {
            Selenide.back();
            count++;
        }
    }
}
