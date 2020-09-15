package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

	public static WebDriver driver;

//	@BeforeTest
	public void chromer_driver() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	public WebDriver getChromerDriver() {
		return driver;
	}

	public void setChromeDriver(WebDriver driver) {
		Driver.driver = driver;
	}
	
	
//	@AfterTest
	public void afterTest(){
		
		driver.quit();
		System.out.println("Execution after Test : quitting browser");
		
	}
}
