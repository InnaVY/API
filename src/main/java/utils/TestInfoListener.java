package utils;

import logger.TestLogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestInfoListener implements ITestListener {
String description;

    public String getDescription(ITestResult iTestResult){
        return iTestResult.getMethod().getDescription();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        description = getDescription(iTestResult);
        TestLogger.logAction("------start test %s-----".formatted(description));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        TestLogger.logAction("------PASSED test %s-----".formatted(description));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        TestLogger.logError(iTestResult.getThrowable().getMessage());
        TestLogger.logAction("------FAILED test %s-----".formatted(description));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        TestLogger.logAction("------SKIPPED test %s-----".formatted(description));
    }
}
