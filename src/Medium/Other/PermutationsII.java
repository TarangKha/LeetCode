package Medium.Other;

import java.util.*;
import java.io.*;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testCase = {1,1,2};
		List<List<Integer>> answer = permuteUnique(testCase);
		
		for(int j = 0; j < answer.size(); j++) {
			for(int i = 0; i < answer.get(j).size(); i++) {
				System.out.print(answer.get(j).get(i) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> visited = new HashSet<Integer>();
		List<Integer> entry = new ArrayList<Integer>();
		
		helper(nums, 0, answer, set, visited, entry, 1);
		
		return answer;
        
    }
	
	public static void helper(int[] input, int currI, List<List<Integer>> list, HashSet<String> memoSet, HashSet<Integer> visitedSet, List<Integer> currList, int depth) {
		if(depth > input.length) {
			list.add(currList);
			currList.remove(currList.size()-1);
			visitedSet.clear();
			return;
		}
		int numOfVisits = 0;
		for(int i = 0; i < input.length; i++) {
			if(!memoSet.add(input[i] + "/" + depth)) {
				continue;
			}
			if(!visitedSet.add(i)) {
				continue;
			}
			currList.add(input[currI]);
			numOfVisits++;
			helper(input, currI+1, list, memoSet, visitedSet, currList, depth+1);
		}
		
		return;
	}

}
