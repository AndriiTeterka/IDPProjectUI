package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    String URL = readConfig().getString("url");
    String EMAIL = readConfig().getString("Credentials.correct.email");
    String PASSWORD = readConfig().getString("Credentials.correct.password");
    String USER_NAME = readConfig().getString("Credentials.correct.userName");
    String INCORRECT_EMAIL = readConfig().getString("Credentials.incorrect.email");
    String INCORRECT_PASSWORD = readConfig().getString("Credentials.incorrect.password");
    String GENERAL_ERROR = readConfig().getString("ErrorMessages.generalError");
    String INCORRECT_EMAIL_ERROR = readConfig().getString("ErrorMessages.incorrectEmail");
    String INCORRECT_PASSWORD_ERROR = readConfig().getString("ErrorMessages.incorrectPassword");


    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
