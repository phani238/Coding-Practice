package com.phani.testing;

import java.util.Arrays;
import java.util.List;

public class Test 
{
	static String str = "abc,abc,abc,phani";
	static List<String> list = Arrays.asList("Phani", null, "Chandra");
	
	static boolean out = false;
	
	public static void main(String[] args) {
		//takingStringFromLastArray();
		
		List<String> list2;
		System.out.println(list.get(0)+list.get(1)+list.get(2));
	}

	public static void takingStringFromLastArray() {
		if(str.contains(","))
		{
			for(int j=str.length()-1;j>0;j--)
			{
				if(!out)
				{
					if(String.valueOf(str.charAt(j)).equals(","))
					{	
						System.out.println(str.substring(j+1));
						out = true;
						break;
					}
				}
			}
		}
		else
			System.out.println(str);
	}

}
