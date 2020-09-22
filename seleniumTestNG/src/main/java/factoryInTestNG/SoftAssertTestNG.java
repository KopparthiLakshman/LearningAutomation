package factoryInTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTestNG {
	public static SoftAssert soft;

	@Test(description = "How to use the soft assert in TestNG SfotAssertClass()")
	private void SfotAssertClass() {
		soft = new SoftAssert();
		System.out.println("After creation of object for soft assert SfotAssertClass()");
		soft.assertEquals(12, 12, "Comparing the actual and expected using soft assert SfotAssertClass()");
		System.out.println("After Soft assert SfotAssertClass()");

		soft.assertEquals(12, 1, "Comparing the actual and expected using soft assert SfotAssertClass(fail)");
		System.out.println("After Soft assert SfotAssertClass(fail)");

		
		soft.assertAll();
		
	}

	
	
	@Test(description = "How to use the soft assert in TestNG SfotAssertClass2()")
	private void SfotAssertClass2() {
		soft = new SoftAssert();
		System.out.println("After creation of object for soft assert SfotAssertClass2()");
		soft.assertEquals(12, 12, "Comparing the actual and expected using soft assert SfotAssertClass2()");
		System.out.println("After Soft assert SfotAssertClass2()");
		soft.assertAll();
	}

}
