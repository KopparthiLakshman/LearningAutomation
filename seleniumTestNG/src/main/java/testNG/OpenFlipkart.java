package testNG;

import org.testng.annotations.Test;

public class OpenFlipkart extends Driver {

	public OpenFlipkart() {
		driver = getChromerDriver();
	}
	
	@Test
	public void scrolling() throws Exception {
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		driver.switchTo().window("1");
//		driver.findElement(By.className("_2AkmmA _29YdH8")).click();
//		Thread.sleep(2000);
//		driver.quit();
	}
}
