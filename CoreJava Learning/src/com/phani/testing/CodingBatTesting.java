package com.phani.testing;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CodingBatTesting {

	@Test
	public void test()
	{
		String name = "silverlake6";
		int i = 2;
		System.out.println(name.length()/2);
		String expected = "slelk";
		
		String str = name.substring(0,1);
		StringBuilder sb = new StringBuilder();
		sb.append(name.substring(i, i+1));
		String actual = str+sb.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void concatTest()
	{
		String actual = "coding";
		
		String b = "demooo";
		int i = actual.length();
		String last = String.valueOf(actual.charAt(actual.length()-1));
		String lastButOne = String.valueOf(actual.charAt(actual.length()-2));
		String expected = actual.substring(0,i-2)+last+lastButOne;
		assertEquals("codign",expected);
	}
	
	@Test
	public void removeStringTest()
	{
		String actual = "abcdefghijkl";
		String first = actual.substring(0,1);
		if(first.equals("a"))
			System.out.println("success");
	}
	
	@Test
	public void compareTest()
	{
		String digits = "12312";
		String numerals = "12312";
		if(digits.compareTo(numerals)==0)
			System.out.println("adcadcadcadc");
		
		String first = digits.substring(0,2);
		String last = digits.substring(digits.length()-1, digits.length());
		
		if(first.equals(last));
			System.out.println(digits.substring(2,digits.length()));

		if(first==last);
			System.out.println(digits.substring(2,digits.length()));
	}
	
}
