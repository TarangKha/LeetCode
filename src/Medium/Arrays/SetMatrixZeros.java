package Medium.Arrays;

import java.util.ArrayList;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,1},{1,0,1},{1,1,1}, {1,1,1}};
		int N = test[0].length;
		int M = test.length;
		System.out.println("N = " + N);
		System.out.println("M = " + M);
		for(int row=0;row < M;row++) {
			System.out.println();
			for(int col=0; col < N; col++) {
				System.out.print(" " + test[row][col] + " ");
			}
		}
		System.out.println();
		System.out.println("Set Zeros-----");
		setMatrixZeros(test);
		for(int row=0;row < M;row++) {
			System.out.println();
			for(int col=0; col < N; col++) {
				System.out.print(" " + test[row][col] + " ");
			}
		}
	}
	
	public static void setMatrixZeros(int[][] input) {
		int N = input[0].length;
		int M = input.length;
		ArrayList<Integer[]> zeroPositions = new ArrayList<Integer[]>();
		for(int row=0;row < M;row++) {
			for(int col=0; col < N; col++) {
				if(input[row][col] == 0) {
					Integer[] position = {row,col};
					zeroPositions.add(position);
				}
			}
		}
		/*
		for(int i =0; i<zeroPositions.size();i++) {
			System.out.print(zeroPositions.get(i) + " ");
		}
		*/
		for(int row=0;row < M;row++) {
			for(int col=0; col < N; col++) {
				Integer[] place = {row, col};
				Boolean exists = false;
				if(input[row][col] == 0) {
					for(int k = 0; k<zeroPositions.size();k++) {
						if(place[0].equals(zeroPositions.get(k)[0]) && place[1].equals(zeroPositions.get(k)[1])) {
							exists = true;
						}
					}
					if (exists) {
						for(int i=0;i<M;i++) {
							input[i][col] = 0;
						}
						for(int i=0;i<N;i++) {
							input[row][i] = 0;
						}
					}
				}
			}
		}
	}
}
