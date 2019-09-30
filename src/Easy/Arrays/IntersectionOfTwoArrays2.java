package Easy.Arrays;

import java.util.ArrayList;

public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		int[] a = {1};
		int[] b = {1,1};
		
		int len;
		if (a.length <= b.length){
			len = a.length;
		} else {
			len = b.length;
		}
		
		int[] ans = intersect(a,b);
		for (int i = 0; i < len; i++) {
			System.out.println(ans[i]);
		}
		// TODO Auto-generated method stub
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		//create answer array of the size of smaller input
		if(nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		int[] shorter;
		int[] longer;
		int[] answer;
		int sizeOfAnswer = 0;
		if (nums1.length <= nums2.length){
			shorter = nums1;
			longer = nums2;
			answer = new int[nums1.length];
		} else {
			shorter = nums2;
			longer = nums1;
			answer = new int[nums1.length];
		}
		//iterate through each array
		for(int nums1counter = 0; nums1counter < longer.length; nums1counter++){
			for(int nums2counter = 0; nums2counter < shorter.length; nums2counter++){
				int answerCounter = 0;
				while ((nums1counter < longer.length) && (nums2counter < shorter.length) && (longer[nums1counter] == shorter[nums2counter]) ){
					answer[answerCounter] = shorter[nums2counter];
					answerCounter++;
					nums1counter++;
					nums2counter++;
					if (answerCounter > sizeOfAnswer) {
						sizeOfAnswer++;
					}
				}
				nums1counter = nums1counter - answerCounter;
				nums2counter = nums2counter - answerCounter;
			}
		}
		int[] solution = new int[sizeOfAnswer];
		for (int i = 0; i < solution.length; i++) {
			solution[i] = answer[i];
		}
    return solution;
	}
	
	
	// ALTERNATE WAY ERROR! USING ARRAYLIST
	
	public static int[] intersect2(int[] nums1, int[] nums2) {
		//create answer array of the size of smaller input
		if(nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		int[] shorter;
		int[] longer;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if (nums1.length <= nums2.length){
			shorter = nums1;
			longer = nums2;
		} else {
			shorter = nums2;
			longer = nums1;
		}
		//iterate through each array
		for(int nums1counter = 0; nums1counter < longer.length; nums1counter++){
			for(int nums2counter = 0; nums2counter < shorter.length; nums2counter++){
				int answerCounter = 0;
				while ((nums1counter < longer.length) && (nums2counter < nums2.length) && (longer[nums1counter] == shorter[nums2counter]) ){
					answer.add(answerCounter, (Integer)shorter[nums2counter]);
					answerCounter++;
					nums1counter++;
					nums2counter++;
				}
				nums1counter = nums1counter - answerCounter;
				nums2counter = nums2counter - answerCounter;
			}
		}
		int[] solution = new int[answer.size()];
		for(int i = 0; i < answer.size(); i++) {
			solution[i] = answer.get(i);
		}
    return solution;
	}
}
