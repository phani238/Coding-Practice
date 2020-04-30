package com.phani.testing;

public class MixString {

	static String str1 = "abc";
	static String str2 = "defwww";
	static String strNew = "";
	public static void main(String[] args) {
		if(str1.length() == str2.length())
		{
			for(int i=0; i<str1.length();i++)
			{
				strNew += String.valueOf(str1.charAt(i))+String.valueOf(str2.charAt(i));
			}
		}
		else if(str1.length() > str2.length())
		{
			for(int i=0; i<str1.length();i++)
			{
				if(i<=str2.length()-1)
					strNew += String.valueOf(str1.charAt(i))+String.valueOf(str2.charAt(i));
				else
					strNew += String.valueOf(str1.charAt(i));
			}
		}
		else if(str1.length() < str2.length())
		{
			for(int i=0; i<str2.length();i++)
			{
				if(i<=str1.length()-1)
					strNew += String.valueOf(str1.charAt(i))+String.valueOf(str2.charAt(i));
				else
					strNew += String.valueOf(str2.charAt(i));
			}
		}
		
		System.out.println(strNew);
	}

}
