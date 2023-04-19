package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public void setUp() {
        //TODO implement driver factory
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
    }

    @BeforeTest
    public void init() {
        setUp();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
