package Medium.Math;

import java.io.*;
import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(1012831527));
	}
	
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int value = n;
        int sum = 0;
        long currentDigit = 1;
        int numOfDigits = 0;
        
        while(value != 1){
            //moves currentDigit to highest digit placement;
            while(value >= currentDigit) {
                currentDigit = currentDigit*10;
                numOfDigits++;
            }
            currentDigit = currentDigit/10;

            //populates Div with Highest digit in [0]
            for(int i = 0; i < numOfDigits; i++) {
            	digits.add((int)(value/currentDigit));
                value = (int)(value%currentDigit);
                currentDigit = currentDigit/10;
            }
            
            for(int i = 0; i < digits.size();i++){
                sum = sum + digits.get(i)*digits.get(i);
            }
            if(!set.add(sum)){
                return false;
            }
            value = sum;
            digits.clear();
            sum = 0;
            currentDigit = 1;
            numOfDigits = 0;
        }
        return true;   
    }

}
