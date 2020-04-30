package com.phani.testing;

public class CountXX {

	public static void main(String[] args) {
		String str = "abc1xwx";
		int count = 0;
		for(int i=0; i<str.length() ; i++)
		{
			if(i<(str.length()-2))
			{
				if(str.substring(i,i+2).equals("xx"))
				{
					count++;
				}
			}
			else
			{
				if(str.substring(i).equals("xx"))
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
