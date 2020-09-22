package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import retryTest.MyRetry;

public class dependsOnMethod {
	
	@Test(groups= {"group1"}, retryAnalyzer = MyRetry.class)
	public void startApp() {
		Assert.assertTrue(false, "Force fully failling the ");
		System.out.println("Start the web browser in startApp()");
	}

	@Test(groups = {"group1"})
	public void startAppqwe() {
		Assert.assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in startAppqwe()");		
	}

	@Test(dependsOnMethods="startApp", dependsOnGroups= {"group1"})
	public void LoginIntoApp() {
		System.out.println("Start the web browser in LoginIntoApp()");
	}

	@Test(alwaysRun = true, dependsOnMethods={"startApp"},description =  "Execution of alwways run true" )
	public void alwaysrun() {
		System.out.println("Start the web browser alwaysrun()");
	}

	
	@Test(dependsOnMethods="startApp")
	public void LogoutFromApp() {
		System.out.println("Start the web browser LogoutFromApp()");
	}

}
