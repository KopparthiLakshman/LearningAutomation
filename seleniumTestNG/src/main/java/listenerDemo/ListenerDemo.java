package listenerDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerDemo extends Assert implements ITestListener/* , ITestContext */ {

	WebDriver driver;
	
	public void onTestStart(ITestResult result) {
		Reporter.log("Testin execution start in OnTestStart method in Listerner class");
		System.out.println(" Class from listener :: " +result.getClass().getName() + " :: Method :: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" Logging from Printing in onTestSuccess() :: " +result.getStatus());
	}

	public void onTestFailure(ITestResult result, WebElement ele) {
		System.out.println(" Logging from Printing in onTestFailure() :: " +result.getStatus());
		File src = ele.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyDirectory(src, new File(""));
			Reporter.log("");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
