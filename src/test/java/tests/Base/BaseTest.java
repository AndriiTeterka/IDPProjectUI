package tests.Base;

import PageComponents.*;
import Pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigProvider;

/**
 The BaseTest class is the base class for all test classes in the project.
 It initializes the necessary pages and components and provides setup and teardown methods.
 Note: The TODO comments in the code indicate areas that need to be implemented or customized.
 */
public class BaseTest {
    protected CartPage cartPage;
    protected CartFlyout cartFlyout;
    protected FiltersSidebar filtersSidebar;
    protected FooterNavigationBar footerNavigationBar;
    protected HeaderNavigationBar headerNavigationBar;
    protected SearchBar searchBar;

    protected SearchResultsPage searchResultsPage;
    protected AccountListFlyout accountListFlyout;
    protected HomePage homePage;
    protected ItemsListPage itemsListPage;
    protected MainMenuSidebar mainMenuSidebar;
    protected ProductConfirmationPage productConfirmationPage;
    protected ProductDetailsPage productDetailsPage;
    protected ProductCheckoutPage productCheckoutPage;
    protected SignInPage signInPage;
    protected YourAccountPage yourAccountPage;
    protected YourAddressesPage yourAddressesPage;

    /**
     * Method to perform the initial setup for the tests.
     * It sets up the WebDriver, Selenide configuration, and Allure Selenide listener.
     */
    public void setUp() {
        //TODO implement driver factory
        WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--headless")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");
        Configuration.timeout = 6000;
        Configuration.reportsFolder = "target/allure-results";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /**
     * Method to perform the setup before each test method.
     * It calls the setUp, initPages, and initComponents methods,
     * and opens the URL specified in the ConfigProvider.
     */
    @BeforeMethod(alwaysRun = true)
    public void init() {
        setUp();
        initPages();
        initComponents();
        Selenide.open(ConfigProvider.URL);
    }

    /**
     * Method to perform the teardown after each test method.
     * It closes the WebDriver.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Method to initialize the pages used in the tests.
     */
    public void initPages() {
        cartPage = new CartPage();
        homePage = new HomePage();
        itemsListPage = new ItemsListPage();
        productConfirmationPage = new ProductConfirmationPage();
        productDetailsPage = new ProductDetailsPage();
        signInPage = new SignInPage();
        searchResultsPage = new SearchResultsPage();
        productCheckoutPage = new ProductCheckoutPage();
        yourAccountPage = new YourAccountPage();
        yourAddressesPage = new YourAddressesPage();
    }

    /**
     * Method to initialize the components used in the tests.
     */
    public void initComponents() {
        cartFlyout = new CartFlyout();
        filtersSidebar = new FiltersSidebar();
        footerNavigationBar = new FooterNavigationBar();
        headerNavigationBar = new HeaderNavigationBar();
        searchBar = new SearchBar();
        accountListFlyout = new AccountListFlyout();
        mainMenuSidebar = new MainMenuSidebar();
    }
}
