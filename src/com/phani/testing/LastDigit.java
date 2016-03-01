package com.phani.testing;

public class LastDigit {

	static int a = 3;
	static int b = 19;
	static int c = 12;
	
	public static void main(String[] args) 
	{
		int aRight = rightMostDigit(a);
		int bRight = rightMostDigit(b);
		int cRight = rightMostDigit(c);
		if((aRight == bRight) || (aRight == cRight) || (bRight == cRight))
			System.out.println("success");
		else
			System.out.println("fail");
			
	}

	public static int rightMostDigit(int val)
	{
		String valStr = String.valueOf(val);
		return Integer.parseInt(valStr.substring(valStr.length()-1));
	}
}
