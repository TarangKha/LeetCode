package Easy.Strings;

import java.math.*;

public class validPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "race car";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] word = s.toCharArray();
        int spaces = 0;
        for (int i = 0; i < word.length; i++){
            word[i - spaces] = word[i];
            if(word[i] == ' '){
                spaces++;
            }
        }
        char[] fixedS = new char[word.length - spaces];
        
        System.out.println(fixedS[2]);
        if (fixedS[0] == ' ') {
        	System.out.println("hi");
        }
        System.out.println(word.length);
        
        fixedS = word; // ??????????
        
        
        System.out.println(fixedS);
        
        for (int i = 0; i < fixedS.length; i++) {
        	fixedS[i] = word[i];
        }
        
        
        //System.out.println(fixedS);
        
        for(int i = 0; i < fixedS.length/2; i++){
            if (fixedS[i] != fixedS[fixedS.length - 1 - i]){
                return false;
            }
        }
        return true;
    }

}
