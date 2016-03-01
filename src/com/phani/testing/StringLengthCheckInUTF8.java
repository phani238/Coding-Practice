package com.phani.testing;


public class StringLengthCheckInUTF8 {

	public static void main(String[] args) throws Exception {
		String s = "phanichandra";
		int length = s.getBytes("UTF-8").length;
		System.out.println(length);
	}

}
