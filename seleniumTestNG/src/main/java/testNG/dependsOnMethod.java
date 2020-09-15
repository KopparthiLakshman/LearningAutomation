package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsOnMethod {
	
	int a =1;
	@Test(groups= {"group2"})
	public void startApp() {
		Assert.assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in group 2");
	}

	@Test(groups = {"group1"})
	public void startAppqwe() {
		Assert.assertTrue(true, "Force fully failling the ");
		System.out.println("Start the web browser in group1");		
	}

	@Test(dependsOnMethods="startApp", dependsOnGroups= "a")
	public void LoginIntoApp() {
		System.out.println("Start the web browser including depends on group ans methos");
	}

	@Test(dependsOnMethods="startApp")
	public void LogoutFromApp() {
		System.out.println("Start the web browser");
	}

}
