package Medium.Backtracking;

import java.util.*;
import java.io.*;
import Medium.Backtracking.TrieNode;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tc1 = "23";
		List<String> result = letterCombinations(tc1);
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
	public static List<String> letterCombinations(String digits){
		if(digits.length() == 0) {
			return null;
		}
		//build the tree
		Queue<TrieNode> parent = new LinkedList<TrieNode>();
		Queue<TrieNode> child = new LinkedList<TrieNode>();
		TrieNode root = new TrieNode();
		parent.add(root);
		for(int i = 0; i < digits.length(); i++) {
			char num = digits.charAt(i);
			int flag = 0;
			while(!parent.isEmpty()) {
				TrieNode temp = parent.remove();
				switch(num) {
					case '2':
						TrieNode kid1 = new TrieNode('a');
						TrieNode kid2 = new TrieNode('b');
						TrieNode kid3 = new TrieNode('c');
						
						if(flag == 0) {
							child.add(kid1);
							child.add(kid2);
							child.add(kid3);
						}
						
						temp.children.add(kid1);
						temp.children.add(kid2);
						temp.children.add(kid3);
						
						break;
					case '3':
						TrieNode kid4 = new TrieNode('d');
						TrieNode kid5 = new TrieNode('e');
						TrieNode kid6 = new TrieNode('f');
						
						if(flag == 0) {
						child.add(kid4);
						child.add(kid5);
						child.add(kid6);
						}
						
						temp.children.add(kid4);
						temp.children.add(kid5);
						temp.children.add(kid6);
						
						break;
					case '4':
						TrieNode kid7 = new TrieNode('g');
						TrieNode kid8 = new TrieNode('h');
						TrieNode kid9 = new TrieNode('i');
						
						if(flag == 0) {
						child.add(kid7);
						child.add(kid8);
						child.add(kid9);
						}
						temp.children.add(kid7);
						temp.children.add(kid8);
						temp.children.add(kid9);
						
						break;
					case '5':
						TrieNode kid10 = new TrieNode('j');
						TrieNode kid11 = new TrieNode('k');
						TrieNode kid12 = new TrieNode('l');
						
						if(flag == 0) {
						child.add(kid10);
						child.add(kid11);
						child.add(kid12);
						}
						
						temp.children.add(kid10);
						temp.children.add(kid11);
						temp.children.add(kid12);
						
						break;
					case '6':
						TrieNode kid13 = new TrieNode('m');
						TrieNode kid14 = new TrieNode('n');
						TrieNode kid15 = new TrieNode('o');
						
						if(flag == 0) {
						child.add(kid13);
						child.add(kid14);
						child.add(kid15);
						}
						temp.children.add(kid13);
						temp.children.add(kid14);
						temp.children.add(kid15);
						
						break;
					case '7':
						TrieNode kid16 = new TrieNode('p');
						TrieNode kid17 = new TrieNode('q');
						TrieNode kid18 = new TrieNode('r');
						TrieNode kid19 = new TrieNode('s');
						
						if(flag == 0) {
						child.add(kid16);
						child.add(kid17);
						child.add(kid18);
						child.add(kid19);
						}
						
						temp.children.add(kid16);
						temp.children.add(kid17);
						temp.children.add(kid18);
						temp.children.add(kid19);
						
						break;
					case '8':
						TrieNode kid20 = new TrieNode('t');
						TrieNode kid21 = new TrieNode('u');
						TrieNode kid22 = new TrieNode('v');
						
						if(flag == 0) {
						child.add(kid20);
						child.add(kid21);
						child.add(kid22);
						}
						
						temp.children.add(kid20);
						temp.children.add(kid21);
						temp.children.add(kid22);
						
						break;
					case '9':
						TrieNode kid23 = new TrieNode('w');
						TrieNode kid24 = new TrieNode('x');
						TrieNode kid25 = new TrieNode('y');
						TrieNode kid26 = new TrieNode('z');
						
						if(flag == 0) {
						child.add(kid23);
						child.add(kid24);
						child.add(kid25);
						child.add(kid26);
						}
						temp.children.add(kid23);
						temp.children.add(kid24);
						temp.children.add(kid25);
						temp.children.add(kid26);
						
						break;
				}
				flag = 1;
			}
			while(!child.isEmpty()) {
				parent.add(child.remove());
			}
		}
		
		//recurse the tree
		ArrayList<String> answer = new ArrayList<String>();
		return helper("", root, answer);
	}
	
	public static List<String> helper(String word, TrieNode node, ArrayList<String> answer){
		if(node.c != null) {
			word = word + node.c;
		}
		if(node.children.size() == 0) {
			answer.add(word);
			word = word.substring(0, word.length()-1);
			return answer;
		}
		for(int i = 0; i < node.children.size(); i++) {
			helper(word, node.children.get(i), answer);
		}
		return answer;
	}
}