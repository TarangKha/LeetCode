package Medium.Backtracking;

import java.util.*;
import java.io.*;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		List<List<Integer>> result = permute(nums);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	public static List<List<Integer>> permute (int[] nums) {
		ArrayList<Integer> entry = new ArrayList<Integer>();
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		if(nums.length == 0) {
			return answer;
		}
		answer = helper(nums, nums.length, entry, answer);
		answer.removeIf(n -> (n.size() != nums.length));
		return answer;
    }
	
	public static List<List<Integer>> helper(int[] nums, int index, ArrayList<Integer> entry, List<List<Integer>> answer){
		if(index == 0) {
			entry = new ArrayList<Integer>();
			entry.add(nums[index]);
			answer.add(entry);
			return answer;
		}
		answer = helper(nums, index - 1, entry, answer);
		if(index < nums.length) {
			int answerSize = answer.size();
			for(int i = 0; i < answerSize; i++) {
				for(int j = 0; j <= answer.get(i).size(); j++) {
					entry = new ArrayList<Integer>(answer.get(i));
					entry.add(j, nums[index]);
					answer.add(entry);
				}
			}
		}
		return answer;
	}
}
