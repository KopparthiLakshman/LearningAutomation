package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class Driver {

	public static WebDriver driver;
	public static Duration SECONDS = null;
//	@BeforeTest
	public void chromer_driver() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
//		driver = new ChromeDriver();
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(SECONDS)
//				.pollingEvery(SECONDS)
//				.ignoring(ElementNotVisibleException.class);
//
//		
//		WebElement ele = wait.until(new Function< WebDriver, WebElement>() {
//
//			public WebElement apply(WebDriver t) {
//				return driver.findElement(By.id("xpath"));
//			}});
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
