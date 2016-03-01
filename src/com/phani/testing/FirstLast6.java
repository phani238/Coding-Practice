package com.phani.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstLast6 {
	
	@Test
	public void firstLast6(){		
		int number[] = {1,2,6};
		if(number[0]==6){
			assertEquals(true,number[0]==6);
		}else if(number[number.length-1]==6){
			assertEquals(true,number[number.length-1]==6);
		}
	}
	
	public int[] sample(){
		return new int[] {1,2,3};
	}

}
