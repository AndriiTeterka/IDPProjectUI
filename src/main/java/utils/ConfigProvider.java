package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    //Credentials
    String URL = readConfig().getString("url");
    String EMAIL1 = readConfig().getString("Credentials.correct.email1");
    String EMAIL2 = readConfig().getString("Credentials.correct.email2");
    String PASSWORD = readConfig().getString("Credentials.correct.password");
    String USER_NAME = readConfig().getString("Credentials.correct.userName");

    //Search values
    String LAPTOP_NAME = readConfig().getString("SearchValues.laptop");
    String TV_NAME = readConfig().getString("SearchValues.tv");

    //Search Parameters
    String SUGGESTIONS_QUANTITY = readConfig().getString("SearchParameters.suggestionsQuantity");
    String DEFAULT_SEARCH_DROPDOWN_VALUE = readConfig().getString("SearchParameters.defaultSearchDropdownValue");

    //Page Titles
    String SIGN_IN_PAGE_TITLE = readConfig().getString("PageTitles.signInPage");
    String CART_PAGE_TITLE = readConfig().getString("PageTitles.cartPage");
    String CHECKOUT_PAGE_TITLE = readConfig().getString("PageTitles.checkoutPage");

    //Main Menu Categories
    String COMPUTERS_CATEGORY = readConfig().getString("MainMenuCategories.computers");
    String MONITORS_CATEGORY = readConfig().getString("MainMenuCategories.monitors");

    //Other Messages
    String ADDED_TO_CART_CONFIRMATION_MESSAGE = readConfig().getString("OtherMessages.addedToCartConfirmationMessage");
    String REMOVED_FROM_SHOPPING_CART_MESSAGE = readConfig().getString("OtherMessages.removedFromShoppingCartMessage");

    //Error messages
    String INCORRECT_EMAIL = readConfig().getString("Credentials.incorrect.email");
    String INCORRECT_PASSWORD = readConfig().getString("Credentials.incorrect.password");
    String GENERAL_ERROR = readConfig().getString("ErrorMessages.generalError");
    String INCORRECT_EMAIL_ERROR = readConfig().getString("ErrorMessages.incorrectEmail");
    String INCORRECT_PASSWORD_ERROR = readConfig().getString("ErrorMessages.incorrectPassword");
    String MISSING_EMAIL_ALERT = readConfig().getString("ErrorMessages.missingEmail");
    String MISSING_PASSWORD_ALERT = readConfig().getString("ErrorMessages.missingPassword");

    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
