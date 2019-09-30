package Easy.Misc;

import java.util.*;
import java.io.*;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
	}
	
	public static boolean isValid(String s) {
        if(s.length() < 1){
            return true;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] input = s.toCharArray();
        
        for(int i = 0; i < input.length; i++){
            if(input[i] == '(' || input[i] == '{' || input[i] == '['){
                stack.push(input[i]);
            } else {
                Character compare = stack.pop();
                if((compare == '(' && input[i] != ')' ) || (compare == '{' && input[i] != '}') || (compare == '[' && input[i] != ']') ) {
                	return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
        
    }

}
