package com.phani.testing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ListDuplicateCheck 
{
  static List<String> stringList = Arrays.asList("Phani", "Chandra", "Chandu", "Phani");
  
	public static void main(String[] args) 
	{
		System.out.println("" +findDuplicate(stringList));
	}

	private static String findDuplicate(List<String> stringList2) 
	{
		String str = "";
		
		final Set<String> set1 = new HashSet<String>();
		
		for(String str2 : stringList2)
		{
			if(!set1.add(str2))
			{
				str = "duplicate is true";
			}
			else
			{
				str = "duplicate is false";
			}
		}
		
		return str;
	}

}
