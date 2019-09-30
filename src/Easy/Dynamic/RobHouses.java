package Easy.Dynamic;

public class RobHouses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//minor change

	public static int rob(int[] nums) {
		int evenIndex = 0;
        int oddIndex = 1;
        int evenRob = 0;
        int oddRob = 0;
        if(nums.length == 2){
            if(nums[0] >= nums[1]){
                return nums[0];
            } else {
                return nums[1];
            }
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        for(int i = evenIndex; i < nums.length; i = i+2){
            evenRob = evenRob + nums[i];
        }
        for(int i = oddIndex; i < nums.length; i = i+2){
            oddRob = oddRob + nums[i];
        }
        if(evenRob >= oddRob){
            return evenRob;
        } else {
            return oddRob;
        }
    }
}
