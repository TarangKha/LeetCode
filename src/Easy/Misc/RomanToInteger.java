package Easy.Misc;

import java.util.*;
import java.io.*;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		int[] values = {1,5,10,50,100,500,1000};
        char[] letters = {'I','V','X','L','C','D','M'};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < letters.length; i++) {
        	map.put(letters[i], i);
        }
        
        int slope = 0;
        int num = values[map.get(s.charAt(0))];
        
        for(int i = 1; i < s.length(); i++) {
        	slope = values[map.get(s.charAt(i))] - values[map.get(s.charAt(i-1))];
        	if(slope > 0) { //need to subtract these two values;
        		num += (values[map.get(s.charAt(i))] - values[map.get(s.charAt(i-1))]) - values[map.get(s.charAt(i-1))];
        	} else {
        		num += values[map.get(s.charAt(i))];
        	}
        }
        
        return num;
	}

}
