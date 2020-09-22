package factoryInTestNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.UtilityForDataProvider;

public class DataProviderTestNG {

	
	@Test(dataProvider = "testdata")
	public void withObjectArray(String username, String password) {
		System.out.println("Printing using data provider withObjectArray(0: "+ username +" : "+password);
	}
	
	@DataProvider(name = "testdata")
	public Object[][] DPwithObjectArray() {
		Object[][] data = {{"UserName1", "Password1"},{"UserName2", "Password2"},{"UserName3", "Password3"},{"UserName4", "Password4"}};
		return data;
	}

	
	@Test(dataProvider = "testdata2")
	public void withIteratorAndArray(String username, String password) {
		System.out.println("Printing using data provider withIteratorAndArray(): "+ username +" : "+password);
	}
	
	@DataProvider(name = "testdata2")
	public Iterator<Object[]> DPwithIteratorAndArray() {
		Object[][] data = {{"UserName8", "Password8"},{"UserName5", "Password5"},{"UserName6", "Password6"},{"UserName7", "Password7"}};
		Iterator<Object[]> iterator = Arrays.asList(data).iterator();
		return iterator;
	}

	

	@Test(dataProvider = "testdata1")
	public void testArrayListConverToInterger(String username, String password) {
		System.out.println("Printing using data provider testArrayListConverToInterger(): "+ username +" : "+password);
	}
	
	@DataProvider(name = "testdata1")
	public Iterator<Object[]> DPtestArrayListConverToInterger() {
		ArrayList<Object[]> twoVariables = UtilityForDataProvider.twoVariables();
		return twoVariables.iterator();
		
	}
	
}
