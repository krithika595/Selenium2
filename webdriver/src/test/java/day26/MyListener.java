package day26;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 2 ways to implement listener
 -----------------------------
 class MyListener implements ITestListener
 class MyListerner extends TestListenerAdapter
 */
public class MyListener implements ITestListener{
	
	public void onStart(ITestContext context) {
	    System.out.println("Test execution started...");
	  }

	public void onTestStart(ITestResult result) {
	    System.out.println("Test started.....");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test passed...");
	  }
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test failed...");
	  }

	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test skipped...");
	  }

	public void onFinish(ITestContext context) {
	    System.out.println("Test execution finished...");
	  }
	
}
