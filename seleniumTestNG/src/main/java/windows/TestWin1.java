package windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWin1 {

	@Test
	public void MultWin() throws InterruptedException {

		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		String windowHandle1 = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");
		Set<String> windowHandles = driver.getWindowHandles();
		
		
		for (String string : windowHandles) {
			if (string.equals(windowHandle1)) {
				driver.switchTo().window(string);
				break;
			}
		}
		driver.findElement(By.xpath("//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]"))
		.sendKeys("Selenium Automation tutorials");
		
		Thread.sleep(2000);
		
		
		driver.quit();
		
	}
}
