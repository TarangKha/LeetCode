package Medium.Arrays;

import java.util.*;
import java.io.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> entry = new ArrayList<Integer>();
		if(nums.length < 3) {
			return null;
		}
        for(int i=0; i<nums.length;i++) {
			Integer A = nums[i];
			for(int j=1;j<nums.length;j++){
				Integer B = nums[j];
				for(int k=2;k<nums.length;k++) {
					Integer C = nums[k];
					if(A+B+C == 0) {
						entry.add(A);
						entry.add(B);
						entry.add(C);
						answer.add(entry);
						entry = new ArrayList<Integer>();
					}
				}
			}
		}
		return answer;
	}

}
