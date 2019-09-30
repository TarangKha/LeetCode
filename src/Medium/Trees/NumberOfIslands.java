package Medium.Trees;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] tc1 = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
		};
		char[][] tc2 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'},
		};
		char[][] tc3 = {
				{'1'}
		};
		System.out.println(numOfIslands(tc2));
	}
	
	public static int numOfIslands(char[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		boolean[] island = {false,false,false,false};
		int answer = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1' && visited[i][j] == false) {
					helper(grid, visited, island, i, j, "none");
					// found end of island
									//up			   //down				//left				 //right
					if(island[0] == true && island[1] == true && island[2] == true && island[3] == true) {
						answer++;
					}
					island = new boolean[4];
				}
			}
		}
		return answer;
	}
	
	public static void helper(char[][] grid, boolean[][] visited, boolean[] island, int row, int col, String headed) {
		//-------------------------Base Cases-------------------------
		// hit north wall
		if(row < 0) {
			island[0] = true;
			return;
		}
		// hit south wall
		if(row >= grid.length) {
			island[1] = true;
			return;
		}
		//hit west wall
		if(col < 0) {
			island[2] = true;
			return;
		}
		//hit east wall
		if(col >= grid[row].length) {
			island[3] = true;
			return;
		}
		if(visited[row][col] == true) {
			return;
		}
		//-----------------------MEMOIZATION----------------------------
		//mark this spot as visited
		if(grid[row][col] == '1') {
			visited[row][col] = true;
		}
		//-----------------------REC STEPS------------------------------
		if(grid[row][col] == '1') {
			//up
			helper(grid, visited, island, row-1, col, "up");
			//down
			helper(grid, visited, island, row+1, col, "down");
			//left
			helper(grid, visited, island, row, col-1, "left");
			//right
			helper(grid, visited, island, row, col+1, "right");
			return;
		} else if(grid[row][col] == '0'){ // hit water
			if(headed.equals("up")) {
				island[0] = true;
				return;
			}
			if(headed.equals("down")) {
				island[1] = true;
				return;
			}
			if(headed.equals("left")) {
				island[2] = true;
				return;
			}
			if(headed.equals("right")) {
				island[3] = true;
				return;
			}
		}
		//---------------------- return --------------------------------
	}
}
//if((row-1 >= 0) && visited[row-1][col] == false) {}
//if((row+1 < visited.length) && visited[row+1][col] == false) {}
//if((col-1 >= 0) && visited[row][col-1] == false) {}
//if((col+1 < visited[0].length) && visited[row][col+1] == false) {}