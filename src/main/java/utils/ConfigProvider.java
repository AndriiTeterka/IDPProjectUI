package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    //Credentials
    String URL = readConfig().getString("url");
    String EMAIL = readConfig().getString("Credentials.correct.email");
    String PASSWORD = readConfig().getString("Credentials.correct.password");
    String USER_NAME = readConfig().getString("Credentials.correct.userName");

    //Search values
    String LAPTOP_NAME = readConfig().getString("SearchValues.laptop");

    //Error messages
    String INCORRECT_EMAIL = readConfig().getString("Credentials.incorrect.email");
    String INCORRECT_PASSWORD = readConfig().getString("Credentials.incorrect.password");
    String GENERAL_ERROR = readConfig().getString("ErrorMessages.generalError");
    String INCORRECT_EMAIL_ERROR = readConfig().getString("ErrorMessages.incorrectEmail");
    String INCORRECT_PASSWORD_ERROR = readConfig().getString("ErrorMessages.incorrectPassword");
    String MISSING_EMAIL_ALERT = readConfig().getString("ErrorMessages.missingEmail");
    String MISSING_PASSWORD_ALERT = readConfig().getString("ErrorMessages.missingPassword");

    //Parameters
    String SUGGESTIONS_QUANTITY = readConfig().getString("SearchParameters.suggestionsQuantity");

    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
