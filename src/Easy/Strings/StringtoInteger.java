package Easy.Strings;

import java.util.Stack;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("-91283472332"));
	}
	
	 public static int myAtoi(String str) {
	        int counter = 0;
	        boolean isNegative = false;
	        int answer = 0;
	        long overflowCheck = 0;
	        int base10placement = 1;
	        Stack<Integer> reverse = new Stack<Integer>();
	        
	        //ignores whitespace
	        while((counter < (str.length())) && str.charAt(counter) == ' '){
	            counter++;
	        }
	        
	        //checks if negative
	        if ((counter < (str.length())) && str.charAt(counter) == '-'){
	            isNegative = true;
	            counter++;
	        }
	        
	        //converts
	        while(counter < (str.length())){
	            //if char is not a digit
	            if ((int)str.charAt(counter) > (int)'9' || (int)str.charAt(counter) < (int)'0'){
	                break;
	            }
	            int digit = whatDigit(str.charAt(counter));
	            reverse.push(digit);
	            counter++;
	        }
	        
	        //if first character was not a digit
	        if(reverse.isEmpty()){
	            return 0;
	        }
	        
	        //unreverses number
	        while(!reverse.isEmpty()){
	            Integer digit = reverse.pop();
	            try{
	                //overflowCheck = Math.addExact(overflowCheck, (long)(digit*base10placement));
	                answer = Math.addExact(answer, (digit*base10placement));
	            } catch (ArithmeticException ex){
	                if (isNegative){
	                    return Integer.MIN_VALUE;
	                } else {
	                    return Integer.MAX_VALUE;
	                }
	            }
	            answer = answer + (digit * base10placement);
	            base10placement = base10placement*10;
	        }
	        
	        //chages to Negativa
	        if (isNegative){
	            overflowCheck = 0 - overflowCheck;
	            answer = 0 - answer;
	        }
	        
	        //if out of bounds
	        /*
	        if (overflowCheck > Integer.MAX_VALUE){
	            return Integer.MAX_VALUE;
	        }
	        if (overflowCheck < Integer.MIN_VALUE){
	            return Integer.MIN_VALUE;
	        }
	        */
	        
	        //return
	        return answer;
	    }
	    
	    public static int whatDigit(char input){
	        int answer;
	        switch (input){
	            case '0':
	                answer = 0;
	                break;
	            case '1':
	                answer = 1;
	                break;
	            case '2':
	                answer = 2;
	                break;
	            case '3':
	                answer = 3;
	                break;
	            case '4':
	                answer = 4;
	                break;
	            case '5':
	                answer = 4;
	                break;
	            case '6':
	                answer = 6;
	                break;
	            case '7':
	                answer = 7;
	                break;
	            case '8':
	                answer = 8;
	                break;
	            case '9':
	                answer = 9;
	                break;
	            default:
	                answer = 999;
	                break;
	        }
	        return answer;
	    }

}
