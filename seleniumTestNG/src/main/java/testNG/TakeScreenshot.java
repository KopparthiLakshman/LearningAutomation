package testNG;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
public class TakeScreenshot {

private static final Duration duration = null; 

public static WebDriver driver;

	@Test
	public void takeScreenshot() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkSpace_01_03_2015\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Pass the url
		driver.get("http://www.google.com");

		// Take screenshot and store as a file format
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(30, TimeUnit.SECONDS)

		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(duration.withSeconds(30))
			       .pollingEvery(duration.withSeconds(30))
			       .ignoring(NoSuchElementException.class);

		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id("foo"));
			     }
			   });		
		
		File screenshotAs = foo.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File(""));
		} catch (IOException e) {
			System.out.println("Unable to find the element- Hence no screenshot taken");
		}
		
		
		Actions act = new Actions(driver); 
		act.click(foo);
					   
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		alert.dismiss();	
		
//		driver.findElement(By.id("webelement")).sendKeys(Keys.chord("CTRL/ALT/SHIFT"));

//		String src= ((TakesScreenshot)driver).getScreenshotAs((OutputType.BASE64));
		
//		try {
//			// now copy the  screenshot to desired location using copyFile //method
//			FileUtils.copyFile(src, new File("C:\\Users\\lakshman\\Desktop\\error.png"));}
//		catch (IOException e){
//			System.out.println(e.getMessage());	}
//		System.out.println(src);
//		Actions act = new Actions(driver);
//		driver.quit();	
	}
}
