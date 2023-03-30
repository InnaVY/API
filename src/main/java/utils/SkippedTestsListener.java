package utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.lang.reflect.Method;

public class SkippedTestsListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult){
        final Method method = iInvokedMethod.getTestMethod().getConstructorOrMethod().getMethod();
        if (method.isAnnotationPresent(Skip.class)){
            Skip skip = method.getAnnotation(Skip.class);
            SkipException skipException = new SkipException("REASON: "+skip.reason());
            iTestResult.setStatus(ITestResult.SKIP);
            iTestResult.setThrowable(skipException);
            throw skipException;
        }
    }
}
