package Hard.Leet;

public class UniquePathIII {
	public static void main(String[] args) {
		int[][] test = {{1,0},{0,0},{0,2}};
		int[][] test2 = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		System.out.println(uniquePathsIII(test2));
	}

	public static int uniquePathsIII(int[][] grid) {
		int row = -1;
		int col = -1;
		int emptySpaces = 0;
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 0) {
					emptySpaces++;
				}
				if(grid[i][j] == 1) {
					row = i;
					col = j;
				}
			}
		}
		if(row == -1 || col == -1) {
			return 0;
		}
		int pathNums = helper(row, col, grid, 0, -1, emptySpaces);
		return pathNums;	
    }

	public static int helper(int startRow, int startCol, int[][] grid, int paths, int marked, int emptySpaces) {
		if(startRow < 0 || startCol < 0) {
			return 0;
		}
		if(startRow >= grid.length || startCol >= grid[startRow].length) {
			return 0;
		}if(grid[startRow][startCol] == 2 && marked == emptySpaces) {
			//paths++;
			return 1;
		}
		if(grid[startRow][startCol] == 2) {
			return 0;
		}
		if(grid[startRow][startCol] == 3) {
			//grid[startRow][startCol] = 0;
			return 0;
		}
		if(grid[startRow][startCol] == -1) {
			return 0;
		}
		if(grid[startRow][startCol] == 1) {//first cell
			if(marked == -1) {//first time
				//continue
			} else {
				return 0;
			}
		}
		if(grid[startRow][startCol] != 1) {
			grid[startRow][startCol] = 3;
		}
		paths = helper(startRow+1, startCol, grid, paths, marked+1, emptySpaces) //down
				+
				helper(startRow-1, startCol, grid, paths, marked+1, emptySpaces) //up
				+
				helper(startRow, startCol+1, grid, paths, marked+1, emptySpaces) //right
				+
				helper(startRow, startCol-1, grid, paths, marked+1, emptySpaces) //left
		;
		
		if(grid[startRow][startCol] == 3) {
			grid[startRow][startCol] = 0;
		}
		return paths;
	}
}
