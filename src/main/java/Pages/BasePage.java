package Pages;

import com.codeborne.selenide.Selenide;
import utils.LogUtils;

/**
 * Represents the base page for all pages in the application.
 */
public class BasePage {

    /**
     * Retrieves the title of the current page.
     *
     * @return The title of the page.
     */
    public String getPageTitle() {
        return Selenide.title();
    }

    /**
     * Performs a backward navigation in the browser history.
     *
     * @param amount The number of times to press the back button.
     */
    public void pressBack(int amount) {
        int count = 1;
        while (count <= amount) {
            LogUtils.logInfoMessage("Press Back");
            Selenide.back();
            count++;
        }
    }
}
