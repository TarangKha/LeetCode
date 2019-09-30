package Medium.Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> answer = groupAnagrams(test);
		for (List<String> arr : answer) {
            System.out.println(Arrays.toString(arr.toArray()));
        }
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        //List<String> entry= new ArrayList<String>();
		List<List<String>> answer = new ArrayList<List<String>>();
        ArrayList<String> entry = new ArrayList<String>();
        HashMap<char[], Integer> map = new HashMap<char[], Integer>();
        Integer line = 0;
        for(int i = 0; i < strs.length; i++){
            char[] key = strs[i].toCharArray();
            Arrays.sort(key);
            if(!map.containsKey(key)){
                map.put(key, line);
            } else {
                line = map.get(key);
            }
            try{
                ArrayList<String> temp = (ArrayList<String>) answer.get(line);
                temp.add(strs[i]);
                answer.remove(answer.get(line));
                answer.add(line, temp);
            } catch(IndexOutOfBoundsException e) {
                entry.add(strs[i]);
                answer.add(line, entry);
                entry = new ArrayList<String>();
            }
            line++;
        }
        return answer;
    }
}
