package seleniumInterview;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
	private WebDriver driver;
	private static final String APP_URL = "http://apps.qa2qe.cognizant.e-box.co.in/CustomerRegistration";
	public DriverSetup() {
		System.setProperty("webdriver.ie.driver", "C:\\khaza\\softwares\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
	}
	public WebDriver getDriver() {
		return driver;
	}

	public void launchApp() {
		driver.get(APP_URL);
	}
}

