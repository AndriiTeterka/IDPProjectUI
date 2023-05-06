package Pages;

import com.codeborne.selenide.Selenide;

public class BasePage {

    public String getPageTitle() {
        return Selenide.title();
    }
}
