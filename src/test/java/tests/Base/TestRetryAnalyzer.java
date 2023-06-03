package tests.Base;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 The TestRetryAnalyzer class implements the IRetryAnalyzer and IAnnotationTransformer interfaces.
 It allows retrying failed test methods a certain number of times.
 This class is used to set the retry analyzer for test methods.
 Note: The maxRetryCount variable can be customized to specify the maximum number of retries.
 */
public class TestRetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer {

    private int retryCount = 0;
    private int maxRetryCount = 2;

    /**
     * Method to determine whether to retry the failed test method.
     * It checks if the test result is not successful, and if the maximum retry count has not been reached.
     * If so, it increments the retry count, sets the test result status to FAILURE, and returns true.
     * If the maximum retry count has been reached, it sets the test result status to FAILURE and returns false.
     * If the test result is successful, it sets the test result status to SUCCESS and returns false.
     *
     * @param iTestResult the test result
     * @return true if the test should be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    /**
     * Method to transform the test annotation and set the retry analyzer.
     * It sets the retry analyzer to the TestRetryAnalyzer class for all test methods.
     *
     * @param annotation       the test annotation
     * @param testClass        the test class
     * @param testConstructor  the test constructor
     * @param testMethod       the test method
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
    }
}
