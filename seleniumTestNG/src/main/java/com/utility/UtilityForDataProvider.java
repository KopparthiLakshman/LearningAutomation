package com.utility;

import java.util.ArrayList;

public class UtilityForDataProvider {


	static String user, pass;


	public static ArrayList<Object[]> twoVariables() {

		ArrayList<Object[]> str = new ArrayList<Object[]>();
		for (int i = 0; i < 4; i++) {

			user = "username"+i;
			pass = "password"+i;

			Object[] data =	{user, pass};
			str.add(data);
		}
		
		
		return str;
	}


}
