package Easy.Misc;

import java.util.*;
import java.io.*;

public class PalindromeNumber {
	
	/*
	 * 
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Could you solve it without converting the integer to a string?
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 12331;
		System.out.println(isPalindrome_SOL(test));
		
	}
	
	public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x > 0 && x < 10){
            return true;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = x;
        
        while(num > 0){
            list.add(num%10);
            num = num/10;
        }
        
        for(int i = 0; i < list.size()/2; i++){
            if(list.get(i) != list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
	
	public static boolean isPalindrome_SOL(int x) { //
		if(x < 0 || (x % 10 == 0 && x != 0)){
			return false;
		}
		
		int reversedNumber = 0;
		while(x > reversedNumber) {
			reversedNumber = reversedNumber*10 + x%10;
			x = x/10;
		}
		
		return x == reversedNumber || x == reversedNumber/10;
	}

}
