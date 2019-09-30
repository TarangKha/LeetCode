package Medium.SortSearch;

public class RotatedSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {1,2,3,4,5};
		int[] tc2 = {3,4,5,1,2};
		int k1 = 2;
		
		int[] tc3 = {5,1,2,3,4};
		int k2 = 1;
		int k3 = 4;
		
		int[] tc4 = {4,5,6,7,0,1,2};
		int k4 = 0;
		int k5 = 3;
		
		System.out.println(search(tc4, k5));
		
	}
	
	public static int search(int[] nums, int target) {
		int answer = helper(nums, target, 0, nums.length-1);
		return answer;
    }
	
	public static int helper(int[] nums, int target, int low, int high) {
		int mid = (low+high)/2;
		if(low > high) {
			return -1;
		}
		if(nums[mid] == target) {
			return mid;
		}
		if(nums[low] == target) {
			return low;
		}
		if(nums[high] == target) {
			return high;
		}
		/*
		 * find where the pivot is
		 * if the left value is less than the right
		 * 	-- then the portion from left to right is ordered, and pivot is on other side.
		 * if the left value is greater than the right
		 *  -- then the pivot is between there two values
		 * 
		 */
		if(nums[low] < nums[mid]) {
			if(nums[low] <= target && target < nums[mid]) {
				//recurse left
				return helper(nums, target, low, mid-1);
			} else {
				//recurse right
				return helper(nums,target, mid+1, high);
			}
		}
		if(nums[mid] < nums[low]) {
			if(nums[mid] < target && target <= nums[high]) {
				//recurse right
				return helper(nums,target, mid+1, high);
			} else {
				//recurse left
				return helper(nums, target, low, mid-1);
			}
		}
		return -1;
	}

}
