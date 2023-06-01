package tests;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            FileInputStream fileInputStream = new FileInputStream("build/reports/tests/" + result.getMethod().getMethodName() + ".png");
            byte[] screenshot = fileInputStream.readAllBytes();
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", ".png", screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
