package Medium.Math;

import java.util.HashMap;
import java.util.*;
import java.io.*;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("000"));
	}
	
	public static int numDecodings(String s) {
        HashMap<Integer, Integer> memoMap = new HashMap<Integer, Integer>();
        return helper(s, 0, memoMap);
    }
	
	public static int helper(String s, int index, HashMap<Integer, Integer> memo) {
		if(index == s.length()) {
			return 1;
		}
		if(index > s.length()) {
			return 0;
		}
		if(memo.get(index) == null) {
			int answer = 0;
			if(Integer.parseInt(s.substring(index, index+1)) != 0) {
				answer = answer + helper(s, index+1, memo);
			}
			if(Integer.parseInt(s.substring(index, index+1)) != 0 && index+2 <= s.length() && Integer.parseInt(s.substring(index, index+2))<= 26 ) {
				answer = answer + helper(s, index+2, memo);
			}
			memo.put(index, answer);
			return answer;
		} else {
			return memo.get(index);
		}
	}

}
