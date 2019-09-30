package Medium.Backtracking;

import java.util.*;
import java.io.*;

public class GenerateParens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		ArrayList<String> list = new ArrayList<String>();
		helper(n, "", '(', 1, 0, list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static List<String> helper(int n, String word, Character c, int left, int right, ArrayList<String> list){
		if(left > n) {
			return list;
		}
		if(right > left) {
			return list;
		}
		word = word + c;
		
		if(left == right && right == n && left == n) {
			list.add(word);
			word = word.substring(0, word.length()-1);
			return list;
		}
		helper(n, word, '(', left + 1, right, list);
		helper(n, word, ')', left, right + 1, list);
	
		return list;
	}

}
