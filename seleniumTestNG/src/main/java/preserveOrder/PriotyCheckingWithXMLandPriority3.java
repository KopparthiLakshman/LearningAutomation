package preserveOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriotyCheckingWithXMLandPriority3 extends Assert{

	@Test
	public void startApp() {
		assertTrue(false, "Force fully failling the ");
		System.out.println("Start the web browser in startApp()"+this.getClass());
	}

	@Test
	public void startApa() {
		assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in startAppqwe()"+this.getClass());		
	}

	@Test
	public void LoginIntoApp() {
		System.out.println("Start the web browser in LoginIntoApp()"+this.getClass());
	}

	@Test
	public void alwaysrun() {
		System.out.println("Start the web browser alwaysrun()"+this.getClass());
	}

	@Test
	public void LogoutFromApp() {
		System.out.println("Start the web browser LogoutFromApp()"+this.getClass());
	}


}
