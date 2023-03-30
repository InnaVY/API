package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    static final int RETRY_LIMIT = 3;
    static final int FAILURE_LIMIT= 5;
    static int overallFailures = 0;
    int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        overallFailures++;
        if (counter< RETRY_LIMIT && overallFailures<FAILURE_LIMIT){
            counter++;
            return true;
        }
        return false;
    }
}
