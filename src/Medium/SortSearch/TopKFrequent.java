package Medium.SortSearch;

import java.util.*;
import java.io.*;
import java.security.KeyStore.Entry;

public class TopKFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tc1 = {1,1,1,2,2,3};
		int k1 = 2;
		int[] tc2 = {3,0,1,0};
		int k2 = 1;
		List<Integer> answer = topKFrequent(tc2, k2);
		//Arrays.toString(answer.toArray());
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	
	
	//Misunderstanding
	public static List<Integer> topKFrequentMISUNDERSTANDING(int[] nums, int k) {
		HashMap<Integer, Integer> tempList = new HashMap<Integer, Integer>(); 
		ArrayList<Integer> values = new ArrayList<Integer>();
        HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        
        if(nums.length == 0) {
        	return values;
        }
        if(nums.length == 1) {
        	values.add(nums[0]);
        	return values;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(occurences.containsKey(nums[i])) {
            	occurences.replace(nums[i], occurences.get(nums[i]) + 1);
            	if(occurences.get(nums[i]) == k) {
            		tempList.put(nums[i], 1);
            	}
            	/*if(occurences.get(nums[i]) > k) {
            		tempList.remove(nums[i]);
            	}
            	*/
            } else {
            	occurences.put(nums[i], 1);
            	if(k == 1) {
	            	tempList.put(nums[i], 1);
            	}
            }
        }
        for(Integer entry : tempList.keySet()) {
        	values.add(entry);
        }
        
        return values;
	 }

	public static List<Integer> topKFrequent(int[] nums, int k){
		int[] ranks = new int[k];
		ArrayList<Integer> ranking = new ArrayList<Integer>();
		PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		
		if(nums.length == 0) {
        	return ranking;
        }
        if(nums.length == 1) {
        	ranking.add(nums[0]);
        	return ranking;
        }
        
		for(int i = 0; i < nums.length; i++) {
			if(frequency.putIfAbsent(nums[i], 1) != null) {
				frequency.replace(nums[i], frequency.get(nums[i])+1);
			}
		}
		for(Integer key: frequency.keySet()) {
			//Double val = frequency.get(key) + key.
			//pq.add(val);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		//add key values to answer list
		for(int i = 0; i < k; i++) {
			//Float keyAndVal = pq.poll();
			//int valuePortion = keyAndVal.intValue();
			//int keyPortion = (int) (((float)keyAndVal - (float)valuePortion)*Integer.MAX_VALUE);
			//ranking.add(keyPortion);
		}
			
			
		/*	
			//place elements in array, and if greater than [0] shift to the right,
			//if less than [0] dont include
			if(pq.peek() != null && frequency.get(key) >= pq.peek()) {
				ranking.add(0, key);
			} else if ((pq.size() + 1) <= k){
				ranking.add(key);
			}
            pq.add(frequency.get(key));
			if(pq.size() > k) {
				pq.poll();
				ranking.remove(ranking.size()-1);
			} else {
				ranking.add(key);
			}
		}
		*/
		return ranking;
	}
	
	public class FreqNode{
		int val;
		int freq;
		
		public FreqNode(int value, int frequency) {
			this.val = value;
			this.freq = frequency;
		}
	}
}