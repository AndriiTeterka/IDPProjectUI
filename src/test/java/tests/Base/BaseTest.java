package tests.Base;

import PageComponents.*;
import Pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigProvider;

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

    public void setUp() {
        //TODO implement driver factory
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.headless = true;
        Configuration.timeout = 6000;
        Configuration.reportsFolder = "target/allure-results";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeMethod(alwaysRun = true)
    public void init() {
        setUp();
        initPages();
        initComponents();
        Selenide.open(ConfigProvider.URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Selenide.closeWebDriver();
    }

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
