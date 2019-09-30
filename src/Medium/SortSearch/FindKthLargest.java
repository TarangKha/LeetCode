package Medium.SortSearch;

import java.util.PriorityQueue;

public class FindKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {3,2,1,5,6,4};
		int k1 = 2;
		System.out.println(findKthLargest(tc1, k1));

	}
	 
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	    for(int i : nums)
	    {
	        pq.add(i);
	        if(pq.size()>k) {
	        	pq.poll();
	        }
	    }   
	    return pq.peek();    
	}
}
