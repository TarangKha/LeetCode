package Easy.Trees;

import java.util.ArrayList;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abc";
		ArrayList<String> list = new ArrayList<String>();
		list = stringPermutation(test, " ", list);
		for (String s: list) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> stringPermutation(String input, String s, ArrayList<String> list) {
		if(input.length() == 1) {
			list.add(s);
			s = null;
			return list;
		}
		for(int i = 0; i < input.length(); i++) {
			char letter = input.charAt(i);
			String before = input.substring(0,i);
			String after = input.substring(i+1,input.length());
			String remaining = before.concat(after);
			s = s + letter;
			stringPermutation(remaining, s, list);
		}
		return list;
	}
}
