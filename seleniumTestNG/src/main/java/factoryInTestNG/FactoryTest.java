package factoryInTestNG;

import org.testng.annotations.Factory;

public class FactoryTest {

	
	@Factory
	public Object[] runTheTest() {
		
		Object[] exeTestInBaseClass = new Object[2];
		exeTestInBaseClass[0] = new BaseClass();
		exeTestInBaseClass[1] = new BaseClass();
		
		return exeTestInBaseClass;
	}
	
	
	
}