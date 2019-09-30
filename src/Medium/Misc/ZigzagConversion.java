package Medium.Misc;

import java.util.*;
import java.io.*;

public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("paypalishiring",4));

	}
	
	public static String convert(String s, int numRows) {
		if(s.length() == 0) {
			return "";
		}
		if(numRows == 0 || numRows == 1) {
			return s;
		}
		if(numRows > s.length()) {
			return s;
		}
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int currentRow = 0;
		boolean goingDown = true;
		for(int i = 0; i < s.length(); i++) {
			if(map.get(currentRow) == null) {
				map.put(currentRow, "");
			}
			map.put(currentRow, map.get(currentRow) + s.charAt(i));
			if(currentRow == 0) {
				goingDown = true;
			}
			if(currentRow == numRows-1) {
				goingDown = false;
			}
			currentRow += goingDown ? 1 : -1; 
		}
		String ans = new String();
		for(int i = 0; i < numRows; i++) {
			ans = ans + (map.get(i));
		}
		return ans;
    }

}
