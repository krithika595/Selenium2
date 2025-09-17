package utils;

public class TestResultData {
    private String testName;
    private String status;
    private String errorMessage;
    private String screenshotPath;
    private String executionTime;

    public TestResultData(String testName, String status, String errorMessage, String screenshotPath, String executionTime) {
        this.testName = testName;
        this.status = status;
        this.errorMessage = errorMessage;
        this.screenshotPath = screenshotPath;
        this.executionTime = executionTime;
    }

    public String getTestName() { return testName; }
    public String getStatus() { return status; }
    public String getErrorMessage() { return errorMessage; }
    public String getScreenshotPath() { return screenshotPath; }
    public String getExecutionTime() { return executionTime; }
}
