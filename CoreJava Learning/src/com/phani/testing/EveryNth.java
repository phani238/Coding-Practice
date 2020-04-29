package com.phani.testing;

public class EveryNth {

	public static void main(String[] args) 
	{
		String str = everyNth("Chocolate", 3);
		System.out.println(str);//Cca
	}

	public static String everyNth(String str, int n) 
	{
		String str1 = "" ; 
		str1 += str.substring(0,1);
		int i;
		for(i = n ; i<=(str.length()-1) ; i++)
		{
			str1 += new StringBuilder().append(str.charAt(i));
			i = (i-1)+n;
		}
		return str1;
	}
}
