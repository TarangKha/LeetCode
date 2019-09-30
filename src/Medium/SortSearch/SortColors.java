package Medium.SortSearch;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {1,2,0};
		int[] tc2 = {2,0,2,1,1,0};
		sortColorsANSWER(tc1);
		for(int i = 0; i < tc1.length; i++) {
			System.out.print(tc1[i] + " ");
		}
	}
	
	public static void sortColors(int[] nums) {
		if(nums.length == 0 || nums.length == 1) {
			return;
		}
		int i = 0;
		int beginIdx = 0;
		int endIdx = nums.length-1;
		while(i < nums.length && endIdx >= beginIdx) {
			if(nums[i] == 0) {
				if(swap(nums, beginIdx, i)) {
					beginIdx++;
				}
				i++;
			} else if (nums[i] == 2) {
				if(swap(nums, i, endIdx)) {
					endIdx--;
				}
				i++;
			} else {
				i++;
			}
		}
    }
	
	public static boolean swap(int[] list, int idx1, int idx2) {
		if(idx1 >= idx2) {
			return false;
		} else {
			int temp = list[idx2];
			list[idx2] = list[idx1];
			list[idx1] = temp;
			return true;
		}
	}
	
	public static void sortColorsANSWER(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int cur = 0;
        while (cur <= j){
            if (nums[cur] == 0){
                nums[cur++] = nums[i];
                nums[i++] = 0;
            } else if (nums[cur] == 2){
                nums[cur] = nums[j];
                nums[j--] = 2;
            } else {
                cur++;
            }
        }
    }

}
