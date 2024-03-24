package Utils;

import Pages.BasePage;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    DatabaseReporter databaseReporter;

    public TestListener() {
        databaseReporter = new DatabaseReporter();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        databaseReporter.sendReport(methodName, "Failed");

        try {
            BasePage.captureScreenshot(methodName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        databaseReporter.sendReport(result.getMethod().getMethodName(), "Success");
    }
}
