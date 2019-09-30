package Medium.DynamicProgramming;

import java.util.*;
import java.io.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {10,9,2,5,3,7,101,18};
		//int[] input = {2,2};
		int[] input = {-2,-1};
		System.out.println(lengthOfLIS(input));
	}
	
	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		
		Stack<Integer> minStack = new Stack<Integer>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		
		minStack.push(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			int currVal = nums[i];
			while(minStack.size() > 0 && currVal <= minStack.peek()) {
				answerList.add(minStack.size());
				minStack.pop();
			}
			minStack.push(currVal);
		}
		answerList.add(minStack.size());
		Collections.sort(answerList);
		return answerList.get(answerList.size()-1);
    }
	
	public static int lengthOfLIS_Rec(int nums[]) {
		if(nums.length == 1) {
			return 1;
		}
		if(nums.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] LIS = {-1};
		return helper(nums[0], 0, nums, map, LIS, 1);
	}
	
	public static int helper(int currVal, int index, int[] nums, HashMap<Integer, Integer> map, int[] max, int depth) {
		if(index == nums.length) {
			return depth-1;
		}
		if(nums[index] < currVal) {
			return depth-1;
		}
		if(map.containsKey(index)) {
			return map.get(index);
		}
		
		int value;
		int maxValue = 0;
		int origIndex = index;
		for(int i = index; i < nums.length; i++) {
			value = helper(currVal, i + 1, nums, map, max, depth+1);
			if(value > maxValue) {
				maxValue = value;
			}
			if(value > max[0]) {
				max[0] = value;
			}
			//currVal = nums[i];
		}
		//memo
		map.put(origIndex, maxValue);
		return max[0];
		
	}

}
