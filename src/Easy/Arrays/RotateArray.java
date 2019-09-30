package Easy.Arrays;

import java.lang.Math;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,2,3,4,5,6};
		rotate(test,4);
		for (int i = 0; i <test.length;i++) {
			System.out.println(test[i]);
		}
	}
	
	public static void rotate(int[] nums, int k) {
		k = k%nums.length;
        if (k == 0){
            return;
        }
        if (nums.length == 1){
            return;
        }
        int i = 0;
        int cycle = 0;
        int start = 0;
        int temp = nums[0]; //starts as first element
        for(int counter = 0; counter < nums.length; counter++){
            if ((counter < nums.length) && (i == start)){
                i++;
                start++;
                cycle++;
                temp = nums[i];
            }
            int value = temp;//value becomes temp
            temp = nums[(i+k)%nums.length];//saves number that will be replaced
            nums[(i+k)%nums.length] = value;//replace
            i = (i+k)%nums.length;
        }
        return;
    }
	
	//TC
	/*
	 * [1,2,3,4,5,6]
		4
		
	 */
}

