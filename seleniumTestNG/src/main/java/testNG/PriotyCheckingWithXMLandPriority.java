package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriotyCheckingWithXMLandPriority extends Assert{

	@Test
	public void startApp() {
		assertTrue(false, "Force fully failling the ");
		System.out.println("Start the web browser in startApp()");
	}

	@Test
	public void startApa() {
		assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in startAppqwe()");		
	}

	@Test
	public void LoginIntoApp() {
		System.out.println("Start the web browser in LoginIntoApp()");
	}

	@Test
	public void alwaysrun() {
		System.out.println("Start the web browser alwaysrun()");
	}

	@Test
	public void LogoutFromApp() {
		System.out.println("Start the web browser LogoutFromApp()");
	}


}
