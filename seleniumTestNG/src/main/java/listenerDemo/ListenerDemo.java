package listenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println(" Logging from Printing in onTestStart() :: " +result.getName());
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
