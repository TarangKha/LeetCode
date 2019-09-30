package Medium.DynamicProgramming;

import java.util.HashMap;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {2,3,1,1,4};
		
		int[] tc2 = {3,2,1,0,4};
		System.out.println(canJump(tc1));
	}
	
	public static boolean canJump(int[] nums) {
		int index = 0;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		boolean answer = helper(nums, index, map);
		return answer;
	}
	
	public static boolean helper(int[] nums, int index, HashMap<Integer, Boolean> map) {
		//--------------base cases/pre code----------
		if(index == nums.length-1) { //reached the last index
			return true;
		}
		if(map.get(index) != null && map.get(index) == false) { //memoized, been here and lost
			return false;
		}
		if(index >= nums.length) { //went past last index
			return false;
		}
		
		boolean answer = false;
		for(int i = nums[index]; i >= 1; --i) {
			answer = helper(nums, index+i, map);
			if(answer) {
				return true;
			}
		}
		map.put(index, answer);
		return false;
	}
}
