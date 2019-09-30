package Medium.Backtracking;

import java.util.*;
import java.io.*;

/*
 * build and case / layer approach
 * assume you have the answer to (n-1)
 */

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		List<List<Integer>> result = subsets(nums);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		ArrayList<Integer> entry = new ArrayList<Integer>();
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		if(nums.length == 0) {
			return answer;
		}
		return powerSet(nums, nums.length, entry, answer);
	}

	public static List<List<Integer>> powerSet(int[] nums, int index, ArrayList<Integer> entry, List<List<Integer>> answer) {
		if(index == 0) {
			entry = new ArrayList<Integer>();
			answer.add(entry);
			entry = new ArrayList<Integer>();
			entry.add(nums[0]);
			answer.add(entry);
			return answer;
			//add empty set, and entire set
		}
		answer = powerSet(nums, index - 1, entry, answer);
		if(index < nums.length) {
			int size = answer.size();
			for(int i = 0; i < size; i++) {
				entry = new ArrayList<Integer>(answer.get(i));
				entry.add(nums[index]);
				answer.add(entry);
			}
		}
		return answer;
	}
}
