package Medium.Other;

import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {7, 7, 5, 7, 5, 1, 5, 7, 7, 5, 7, 7, 1, 2, 7, 4};
		System.out.println(majorityElementANS(test));

	}
	
	public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Integer max = null;
        
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);    
            } else {
                map.replace(nums[i], map.get(nums[i])+1);
            }
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
            if(max == null || map.get(nums[i]) > max){
                max = nums[i];
            }
        }
        return max;
    }
	
	public static int majorityElementANS(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
