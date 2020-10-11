package listenerDemo;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerDemo extends Assert implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("Testin execution start in OnTestStart method in Listerner class");
		System.out.println(" Class from listener :: " +result.getClass().getName() + " :: Method :: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" Logging from Printing in onTestSuccess() :: " +result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" Logging from Printing in onTestFailure() :: " +result.getStatus());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(" Logging from Printing in onTestSkipped() :: " +result.getStatus());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Logging from Printing in onTonTestFailedButWithinSuccessPercentageestStart() :: " +result.getStatus());
	}

	public void onStart(ITestContext result) {
		System.out.println(" Logging from Printing in onStart() :: " +result.getClass());
	}


	public void onFinish(ITestContext result) {
		System.out.println(" Logging from Printing in onFinish() :: " +result.getClass());
	}

}
