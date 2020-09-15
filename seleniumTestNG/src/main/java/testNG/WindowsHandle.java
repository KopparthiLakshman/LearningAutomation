package testNG;

import org.testng.annotations.Test;

public class WindowsHandle extends Driver{

	public WindowsHandle() {
		driver = getChromerDriver();
	}
	
	
//	@BeforeTest
	public void getNoOfWindows() {
		driver.getWindowHandle();
	}
	
	@Test
	public void getCurrentWIndow() {
		
	}
	
}
