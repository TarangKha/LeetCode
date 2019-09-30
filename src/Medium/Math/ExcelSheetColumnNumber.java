package Medium.Math;

import java.util.*;
import java.io.*;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "AAB";
		System.out.println(titleToNumber(test1));
	}
	
	public static int titleToNumber(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		initMap(map);
		String input = s.toUpperCase();
		String temp = "";
		//int answer = 0;
		for(int i = input.length() - 1; i >= 0; i--) {
			temp = input.charAt(i) + temp;
			if(map.containsKey(temp)) {
				//answer = map.get(temp);
			} else {
				map.put(temp, (26*titleToNumber(temp.substring(0, temp.length()-1)))+map.get(""+temp.charAt(temp.length()-1)));
			}
		}
		return map.get(input);
    }
	
	public static void initMap(HashMap<String, Integer> map) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 1; i <= 26; i++) {
			map.put("" + alphabet.charAt(i-1), i);
		}
		return;
	}

}
