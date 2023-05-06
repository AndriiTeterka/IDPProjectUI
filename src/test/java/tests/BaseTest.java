package tests;

import PageComponents.*;
import Pages.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigProvider;

public class BaseTest {
    protected CartPage cartPage;
    protected CartSidebar cartSidebar;
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
    protected SignInPage signInPage;

    public void driverSetUp() {
        //TODO implement driver factory
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
    }

    @BeforeTest
    public void init() {
        driverSetUp();
        initPages();
        initComponents();
        Selenide.open(ConfigProvider.URL);
    }

    @AfterTest
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
    }

    public void initComponents() {
        cartSidebar = new CartSidebar();
        filtersSidebar = new FiltersSidebar();
        footerNavigationBar = new FooterNavigationBar();
        headerNavigationBar = new HeaderNavigationBar();
        searchBar = new SearchBar();
        accountListFlyout = new AccountListFlyout();
        mainMenuSidebar = new MainMenuSidebar();
    }
}
