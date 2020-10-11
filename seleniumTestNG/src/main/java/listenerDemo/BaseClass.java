package listenerDemo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



@Listeners(listenerDemo.ListenerDemo.class)
public class BaseClass {
	
//	@MyOwnInterface(myannotate = false)
	@Test( enabled = false, invocationCount = 2, priority = 2 , description = "Executing the TestCase1 method in side BaseClass")
	public void testCase1() {
		System.out.println("Executing the TestCase1 method in side BaseClass");
		
	}
	

	@Test(priority = 1, description = "Executing the TestCase2 method in side BaseClass")
	public void testCase2() {
		System.out.println("Executing the TestCase2 method in side BaseClass");
	}


	
	@Parameters({"Firstname", "LastName"})
	@Test(priority = 3, description = "Executing the TestCase4 method in side BaseClass")
	public void testCase4(@Optional("Firstname") String fName, @Optional("LastName") String lName) {
		System.out.println("Executing the TestCase4 method in side BaseClass"+ " First name ::"+ fName +" :: "+lName );
	}


//	public Class<? extends Annotation> annotationType() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public boolean myannotate() {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	
	
	
	
	
	
	
	
}
