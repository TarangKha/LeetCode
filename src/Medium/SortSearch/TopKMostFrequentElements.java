package Medium.SortSearch;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TopKMostFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2,2,2,1,3,4,5};
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst = topKFrequent(nums, 2);
		System.out.println(lst);
	}

	static ArrayList<Integer> topKFrequent(int[] nums, int k) {
		ArrayList<Integer> lst2 = new ArrayList<Integer>();
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();    
		// create the has map as a frequency table with the values as the frequency
		int maxFrequency = 0;
		int value = 0;
		for (int i = 0;i < nums.length;i++){
			if (hm.containsKey(nums[i])){
				hm.put(nums[i], hm.get(nums[i]) + 1);
			}
			else {
				hm.put(nums[i], 1);
			}
			if (hm.get(nums[i]) > maxFrequency){
				maxFrequency = hm.get(nums[i]);
			}
		}
		// the outer arraylist are the buckets whose index represent the frequency
		// within each arraylist are arraylists which contain the keys for that freqency,
		// thus some buckets may be empty, and some buckets may contain more than keys
		// so if test case is 1,1,1,2,2,3,4,4,4
		// then max freq is 3 so an arraylist of size 3 + 1 would be created
		// arraylist[0] will have an arraylist of size 0
		// arraylist[1] will have an arraylist of size 1 (and contain 3)
		// arraylist[2] will have an arraylist of size 1 (and contain 2)
		// arraylist[3] will have an arraylist of size 2 (and contain 1 & 4)
		
		ArrayList<Integer>[] al = new ArrayList[maxFrequency + 1]; 
		  
        // initializing 
        for (int i = 0; i < al.length; i++) { 
            al[i] = new ArrayList<Integer>(); 
        } 
        
		for(Entry<Integer, Integer> entry : hm.entrySet()){    
			(al[entry.getValue()]).add(entry.getKey());
        }  
		for (int i = al.length - 1;i > 0; i--){
			for (int j = al[i].size() - 1; j >= 0; j--){
				lst2.add(al[i].get(j));
				if (lst2.size() >= k){
					break;
				}
			}
			if (lst2.size() >= k){
				break;
			}
		}
		
	    return lst2;
	}
}


