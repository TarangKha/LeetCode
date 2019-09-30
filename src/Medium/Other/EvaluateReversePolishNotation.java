package Medium.Other;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(input));
	}
	
	public static int evalRPN(String[] tokens) {
		int index = 0;
		int element1 = 0;
		int element2 = 0;
		Stack<Integer> stack = new Stack<Integer>();
		//ArrayList<Character> operators = new ArrayList<Character>();
		while(index < tokens.length) {
			if(tokens[index].equals("+") && !stack.isEmpty()) {
				element2 = stack.pop();
				element1 = stack.pop();
				int answerElement = element1 + element2;
				stack.push(answerElement);
			} else if(tokens[index].equals("-") && !stack.isEmpty()) {
				element2 = stack.pop();
				element1 = stack.pop();
				int answerElement = element1 - element2;
				stack.push(answerElement);
			} else if(tokens[index].equals("*") && !stack.isEmpty()) {
				element2 = stack.pop();
				element1 = stack.pop();
				int answerElement = element1 * element2;
				stack.push(answerElement);
			} else if(tokens[index].equals("/") && !stack.isEmpty()) {
				element2 = stack.pop();
				element1 = stack.pop();
				int answerElement = element1 / element2;
				stack.push(answerElement);
			} else {
				stack.push(Integer.parseInt(tokens[index]));
			}
			index++;
		}
		return stack.pop();
    }
}
