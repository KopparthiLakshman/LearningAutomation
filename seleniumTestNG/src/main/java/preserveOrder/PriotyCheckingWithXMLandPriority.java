package preserveOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriotyCheckingWithXMLandPriority extends Assert{

	@Test(priority = 0)
	public void startApp() {
		assertTrue(false, "Force fully failling the ");
		System.out.println("Start the web browser in startApp()");
	}

	@Test(priority = 1)
	public void startApa() {
		assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in startApa()");		
	}

	@Test(priority = 3)
	public void LoginIntoApp() {
		System.out.println("Start the web browser in LoginIntoApp()");
	}

	@Test(priority = 2)
	public void alwaysrun() {
		System.out.println("Start the web browser alwaysrun()");
	}

	@Test(priority = 4)
	public void LogoutFromApp() {
		System.out.println("Start the web browser LogoutFromApp()");
	}


}
