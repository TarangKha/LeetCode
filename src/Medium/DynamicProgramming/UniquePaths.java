package Medium.DynamicProgramming;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(19,13));
	}
	
	public static int uniquePaths(int m, int n) {
		int[][] board = new int[m][n];
		return helper(board, 0, 0);
	}
	
	public static int helper(int[][] board, int row, int col) {
		if(row >= board.length || col >= board[0].length) {
			return 0;
		}
		
		if(board[row][col] != 0) {
			return board[row][col];
		}
		
		if(row == board.length-1 && col == board[0].length-1) {
			return 1;
		}
		int answer = helper(board, row+1, col) + helper(board, row, col+1);
		if(answer >= 1) {
			//memo
			board[row][col] = answer;
		}
		return answer;
	}

}
