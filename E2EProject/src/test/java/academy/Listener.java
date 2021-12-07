package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listener extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	//for thread safe environment for parallel execution
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);//adding object to pool
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		thread.get().log(Status.PASS, "Test Passed");
		//ITestListener.super.onTestSuccess(result);
	}
	//******************************************************************************
	//******************************************Look down******************
	//*****************&&&&&&&&&&&&&&&&******************************&&&&&&&&&&&&&&&&&&&&&&
	@Override
	public void onTestFailure(ITestResult result) {
		//Screenshot
		//test.fail(result.getThrowable());
		thread.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();//to get the name of method which failed
		try {
			//to get the driver value(instance) from test i.e getting failed
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			String path = getScreenshotPath(testMethodName, driver);//getting the loction where screenshot is created in project

			//adding screenshot to extent reports
			thread.get().addScreenCaptureFromPath(path, testMethodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//ITestListener.super.onTestFailure(result);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		//ITestListener.super.onFinish(context);
	}

}
