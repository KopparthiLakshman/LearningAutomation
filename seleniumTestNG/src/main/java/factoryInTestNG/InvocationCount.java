package factoryInTestNG;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(timeOut = 10000)
	public void name() {
		
//		do
			System.out.println("1");
//		while(true);
	}
}
