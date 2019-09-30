package Medium.SortSearch;

import java.util.*;
import java.io.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tc1 = {
				{15,18},
				{6,10},
				{1,3},
				{2,6}
				};
		int[][] tc2 = {
				{1,4},
				{4,5}
						};
		int[][] answer = merge(tc1);
		System.out.println(Arrays.deepToString(answer));
		
		/*
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i][0] + ",");
			System.out.print(answer[i][1]);
			System.out.println();
		}
		*/
	}
	
	public static int[][] merge(int[][] intervals) {
		if(intervals.length <= 1) {
			return intervals;
		}
        ArrayList<int[]> storage = new ArrayList<int[]>();
		Arrays.sort(intervals, new Comparator<int[]>(){
        	@Override
        	public int compare(int[] entry1, int[] entry2) {
        		if(entry1[0] > entry2[0]) {
        			return 1;
        		} else {
        			return -1;
        		}
        	}
        });
        for(int i = 1; i < intervals.length;i=i+2) {
        	int firstLeftVal = intervals[i-1][0];
        	int firstRightVal = intervals[i-1][1];
        	int secondLeftVal = intervals[i][0];
        	int secondRightVal = intervals[i][1];
        	
        	if(secondLeftVal <= firstRightVal && secondLeftVal >= firstLeftVal) {
        		int[] replacement = {firstLeftVal, secondRightVal};
        		storage.add(replacement);
        	} else {
        		storage.add(intervals[i-1]);
        		storage.add(intervals[i]);
        	}
        }
    	int[][] finalAnswer = new int[storage.size()][2];
    	for(int i = 0; i < storage.size();i++) {
    		finalAnswer[i] = storage.get(i);
    	}
    	return finalAnswer;
    }

}
