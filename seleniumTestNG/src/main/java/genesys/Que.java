package genesys;

import java.util.ArrayList;
import java.util.List;

public class Que {
	/*
	 * Take the string "PROLEARNING" and reverse the string at every 4 characters : example the result should be LORP NRAE GNI
	 * /
	 */
	
	public static void main(String[] args) {

		String input = "PROlL";
		List<String> list = new ArrayList<String>();
		int num =4;
		if(input.length()>num) {
			for (int i = 0; i < input.length(); i=i+num) {
				if((i+num)>input.length()) 
				{
					list.add(input.substring(i, input.length()).toString());
					break;	
				}
				else
					list.add(input.substring(i, i +num).toString());
			}
			System.out.println(list);
		}
		else if (input.length()==num || input.length()<num)
		{
			System.out.println(input);
		}

	}
}
