package utils;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();
    private static List<TestResultData> pdfResults = new ArrayList<>();
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	testReport.get().log(Status.PASS, "Test passed");
        String executionTime = new java.util.Date().toString();
        pdfResults.add(new TestResultData(result.getMethod().getMethodName(), "PASS", null, null, executionTime));
    }
    @Override
    public void onTestFailure(ITestResult result) {
    	testReport.get().log(Status.FAIL, "Test failed: " + result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        String path = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());
        String executionTime = new java.util.Date().toString();

        if (path != null) {
            try {
                testReport.get().addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        pdfResults.add(new TestResultData(
                result.getMethod().getMethodName(),
                "FAIL",
                result.getThrowable().toString(),
                path,
                executionTime
        ));
    }

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
        String pdfPath = System.getProperty("user.dir") + "/reports/TestReport.pdf";
        PdfReportUtil.generatePDF(pdfPath, pdfResults);
        System.out.println("PDF Report generated: " + pdfPath);
    }
}
