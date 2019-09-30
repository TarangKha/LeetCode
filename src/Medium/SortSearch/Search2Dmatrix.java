package Medium.SortSearch;

public class Search2Dmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tc1 = {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				};
		int k1 = 5;
		int k2 = 20;
		
		int[][] tc2 = {{1,2,3,4,5}};
		int k3 = 2;
		System.out.println(searchMatrix(tc2, k3));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) { 
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		if(matrix.length == 1 && matrix[0].length == 1) {
			if(matrix[0][0] == target) {
				return true;
			} else {
				return false;
			}
		}
		if(matrix.length == 1) {
			return arrayBST(matrix[0], target, 0, matrix[0].length - 1);
		}
		if(matrix[0].length == 1) {
			//return arrayBST(matrix[0], target, 0, matrix[0].length - 1);
		}
		return matrixBST(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
	}
	
	public static boolean matrixBST(int[][] matrix, int target, int rowLow, int rowHigh, int colLow, int colHigh) {
		int rowMid = (rowLow + rowHigh)/2;
		int colMid = (colLow + colHigh)/2;
		
		//BST false check
		if(rowLow > rowHigh || colLow > colHigh) {
			return false;
		}
		
		//quick true check
		if(matrix[rowLow][colLow] == target) {
			return true;
		}
		if(matrix[rowHigh][colHigh] == target) {
			return true;
		}
		if(matrix[rowMid][colMid] == target) {
			return true;
		}
		
		if((rowLow == rowHigh && colLow == colHigh) || (rowLow == rowMid && colLow == colMid) || (rowHigh == rowMid && colHigh == colMid)) {
			boolean ans = false;
			//check row
			ans = arrayBST(matrix[rowMid], target, 0, colMid);
			if(ans) {
				return true;
			}
			//check col
			int[] col = new int[rowMid+1];
			for(int i = 0; i <= rowMid; i++) {
				col[i] = matrix[i][colMid];
			}
			ans = arrayBST(col, target, 0, col.length-1);
			if(ans) {
				return true;
			}
		}
		
		//if the diagonal value < target
		// keep searching along diagonal
		if(matrix[rowMid][colMid] < target) {
			return matrixBST(matrix, target, rowMid+1, rowHigh, colMid+1, colHigh);
		} else { //if the diagonal value > target, check this row and col for target.
			return matrixBST(matrix, target, rowLow, rowMid-1, colLow, colMid-1);
		}
	}
	
	public static boolean arrayBST(int[] array, int target, int low, int high) {
		int mid = (low + high)/2;
		if(low > high) {
			return false;
		}
		if(array[mid] == target) {
			return true;
		}
		if(array[mid] > target) {
			return arrayBST(array, target, low, mid-1);
		} else {
			return arrayBST(array, target, mid+1, high);
		}
	}

}
