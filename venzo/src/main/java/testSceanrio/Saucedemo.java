package testSceanrio;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.DriverClass;

public class Saucedemo {

	public static String USERNAME = "", PASSWORD = "";
	DriverClass dc = new DriverClass();
	WebDriver driver;
	
	@BeforeMethod
	private void loadProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis;
		fis = new FileInputStream("login.properties");
		prop.load(fis);
		USERNAME = prop.getProperty("username").toString();
		PASSWORD = prop.getProperty("password").toString();
	}


	@Test
	public void TestLogin() throws IOException, InterruptedException {
		driver = dc.launchChromeBrowser("http://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.close();
		driver.findElement(By.id("password")).sendKeys(PASSWORD,Keys.ENTER);
//		driver.findElement(By.id("pass")).sendKeys(PASSWORD,Keys.ENTER);
		dc.addItemsToCart(driver);
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.alertIsPresent());
		
		
	}


//	@AfterMethod
//	public void closeAllDriverInstances() {
//		driver.quit();
//	}

	
}
