package Medium.SortSearch;

import java.util.*;
import java.io.*;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {2,2};
		int[] tc2 = {5,7,7,8,8,10};
		int t1 = 2;
		int t2 = 8;
		//int[] result = searchRange(tc1, t1);
		int[] result = searchRange(tc2, t2);
		for(int i : result) {
			System.out.print(i);
		}
	}
	
	public static int[] searchRange(int[] nums, int target) {
		if(nums.length == 1 && nums[0] == target) {
			int[] exception = {0,0};
			return exception;
		}
		int[] answer = {-1,-1};
		helper(nums, 0, nums.length-1, target, answer);
        return answer;
    }
	
	public static void helper(int[] nums, int low, int high, int target, int[] answer) {
		int mid = (low+high)/2;
		if(low > high) {
			return;
		}
		if(nums[high] < target) {
			return;
		}
		if(nums[low] > target) {
			return;
		}
		if(nums[mid] == target) {
			if(answer[0] == -1) {
				answer[0] = Integer.MAX_VALUE;
			}
			if(answer[1] == -1) {
				answer[1] = Integer.MIN_VALUE;
			}
			if(mid <= answer[0]) {
				answer[0] = mid;
			}
			if(mid >= answer[1]) {
				answer[1] = mid;
			}
		}
		helper(nums, low, mid-1, target, answer);
		helper(nums, mid+1, high, target, answer);
	}
}
