package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TestNGExxample extends Driver {
	
	public TestNGExxample() {
		driver = getChromerDriver();
	}
	
	
	@Test(priority = 1, description = "second test case created for testNG")
	public void testA() throws InterruptedException {
		
		String url = "http://www.google.co.in";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("test case excuted");
		WebElement ele =driver.findElement(By.xpath("//div[className='hpuQDe']"));
		
		
//		aria-label
		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "second test case created for testNG")
	public void testB() {
		System.out.println("testB");  
	}

}
