package Medium.Backtracking;

import java.util.*;
import java.io.*;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";
		
		char[][] board2 = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};
		
		String word4 = "ABCESEEEFS";
		
		System.out.println(exist(board2, word4));
	}
	
	public static boolean exist(char[][] board, String word) {
		if(word.length() == 0) {
			return false;
		}
		if(board.length == 0 || board[0].length == 0) {
			return false;
		}
		boolean result = false;
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == word.charAt(0)) {
					boolean[][] visited = new boolean[board.length][board[0].length];
					result = searcher(0, row, col, board, word, visited);
					if(result) {
						return true;
					}
				}
			}
		}
		return result;
    }
	
	public static boolean searcher(int index, int row, int col, char[][] board, String word, boolean[][] visited) {
		char letter = word.charAt(index);
		//bunch of if base cases to return false
		//----------------------Out of bounds If's--------------
		if(row < 0 || row >= board.length) {
			return false;
		}
		if(col < 0 || col >= board[row].length) {
			return false;
		}
		//-------------------------------------------------------
		
		
		//-----------------End of Word----------------------------
		if(index >= word.length()) {
			return false;
		}
		//--------------------------------------------------------
		
		
		//-----------------Character doesn't match---------------
		if(letter != board[row][col]) {
			return false;
		}
		//------------------------------------------------------
		
		
		//---------------- Already Visited ---------------------
		if(visited[row][col]) {
			return false;
		}
		//-----------------------------------------------------
		
		//------------Found last letter of word-----------------
		if(letter == board[row][col] && index == word.length()-1) {
			return true;
		}
		//------------------------------------------------------
		
		//---Character matches, now look for next adjacent match---
		//-- mark as visited
		visited[row][col] = true;
		//-- recurse in all directions
		boolean answer =   searcher(index + 1, row - 1, col, board, word, visited) // up
							||
						   searcher(index + 1, row + 1, col, board, word, visited) // down
						    ||
						   searcher(index + 1, row, col - 1, board, word, visited)  //left
						    ||
						   searcher(index + 1, row, col + 1, board, word, visited); //right
		visited[row][col] = false;
		return answer;
	}
}
