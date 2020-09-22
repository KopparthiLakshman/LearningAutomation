package testNG;

import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	//This method will provide data to any test method that declares that its Data Provider
	//is named "test1"
	@DataProvider(name = "test1")
	public Object[] createData1() {
	 return new Object[] {"lakshman"};
	}
	 
	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test1")
	public void verifyData1(String n1) {
	 System.out.println(n1);
	}
	
	
	//This method will provide data to any test method that declares that its Data Provider
	//is named "test1"
	@DataProvider(name = "test2")
	public Iterator<String> createData2() {
		Iterator<String> iterator = Arrays.asList("a", "b","c").iterator();
		return iterator;
	
	}
	 
	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test2")
	public void verifyData11(String data) {
	 System.out.println(data);
	}

	
	/*-----------------------------------------------*/


}
