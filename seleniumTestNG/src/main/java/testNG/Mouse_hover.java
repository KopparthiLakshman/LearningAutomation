package testNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mouse_hover {
	
	WebDriver driver;
	
	@Test
	public void mouse_hover() throws InterruptedException {
			
		System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkSpace_01_03_2015\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url_link = "http://seleniumpractise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html";
		driver.get(url_link);
		Thread.sleep(2000);
		driver.quit();
		
//		Actions act = new Actions(driver);
		
	
	}

}
