package Hard.Leet;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses(")()())"));
	}
	
	public static int longestValidParentheses(String s) {
        int openCount = 0;
        int closedCount = 0;
        int longestSoFar = 0;
        char letter;
        for(int i = 0; i < s.length(); i++){
            letter = s.charAt(i);
            if(letter == '('){
                openCount++;
            } else if (letter == ')'){
                closedCount++;
            }
            if(openCount < closedCount){
                longestSoFar = openCount*2;
                openCount = 0;
                closedCount = 0;
            }
        }
        if (openCount >= closedCount){
            return closedCount * 2;
        } else {
            return longestSoFar;
        }
    }

}
