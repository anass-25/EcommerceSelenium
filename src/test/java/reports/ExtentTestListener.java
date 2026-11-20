package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    private final ExtentReports extent =
            ExtentReportManager.getReport();

    private final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName()
        );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed successfully");
        test.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());
        test.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        if (test.get() != null) {
            test.get().skip("Test skipped");
            test.remove();
        } else {
            extent.createTest(
                    result.getMethod().getMethodName()
            ).skip("Test skipped");
        }
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();
    }
}