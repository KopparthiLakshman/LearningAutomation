package testNG;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PassingMethod {
	
	@DataProvider(name = "dp" ,parallel = true)
	public Object[][] createData3(Method m) {
	  System.out.println(m.getName());  // print test method name
	  return new Object[][] { new Object[] { "Cedric" }};
	}
	
	@Test(dataProvider = "dp")
	public void test3(String s) {
	}
	
	@Test(dataProvider = "dp")
	public void test4(String s) {
	}
	
}

