package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.ConfigProvider;
import utils.LogUtils;

public class TC01_Test extends BaseTest {

    @Step("Open URL")
    @Test
    public void openUrl() {
        LogUtils.logInfoMessage("Opening url");
        Selenide.open(ConfigProvider.URL);
    }
}
