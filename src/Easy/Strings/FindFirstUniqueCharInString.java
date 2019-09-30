package Easy.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class FindFirstUniqueCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcdcbd"; //return a
		System.out.println(GetUnique(str));
		str = "abdcab"; //return d
		System.out.println(GetUnique(str));
		str = "abcdab"; //return c
		System.out.println(GetUnique(str));
		str = "abcdcbd"; //return a
		System.out.println(GetUnique2(str));
		str = "abdcab"; //return d
		System.out.println(GetUnique2(str));
		str = "abcdab"; //return c
		System.out.println(GetUnique2(str));
	}
	
	public static char GetUnique(String str){
		// i didn't use hashset because what if there are more than 1 unique chars and since i have to get the oldest one, the set doesn't preserve the order of insertions
		// i could have used LinkedHashSet or LinkedHasMap because when i create an iterator over it, the iterator works in the order of insertion from oldest to latest
		// but i am using hashmap to store values and indexes and the smallest index will get me the first char in the map
		// i had to spend some time thinking should i make the index the key or the char the key ? because to remove i need the key
		// getting the value from key is easy - use getKey(key)
		// but getting the key from a value is difficult - one way is -  use Map.Entry iterator and then the map.entry has getKey() and getValue() for the next() that the iterator is pointing to
		// i have used the iterator below
		char ch = ' ';
		HashMap map = new HashMap<>();
		for (int i = 0; i < str.length();i++){
			ch = str.charAt(i);
			if (map.containsKey(ch)){
				map.remove(ch);
			}
			else {
				map.put(ch,i);
			}
		}
		ch = ' ';
		Set s = map.entrySet();  //map entry returns all the key-value mappings as a=0,b=1,c=2 etc. into the set
		Iterator i = s.iterator(); // iterator over set so the i.next() contains a=0, they key and the value
		int oldest = Integer.MAX_VALUE;
		while (i.hasNext()){
			Map.Entry me = (Map.Entry)i.next(); // cast by map.entry so now me contains the key a and value 0
			if (((Integer) me.getValue()) < oldest){
				oldest = (Integer) me.getValue();
				ch = (char) me.getKey();
			}
		}
		return ch;
	}
	
	public static char GetUnique2(String str){
		char ch = ' ';
		LinkedHashMap map = new LinkedHashMap<>();
		for (int i = 0; i < str.length();i++){
			ch = str.charAt(i);
			if (map.containsKey(ch)){
				map.remove(ch);
			}
			else {
				map.put(ch,i);
			}
		}
		ch = ' ';
		Set s = map.entrySet();  //map entry returns all the key-value mappings as a=0,b=1,c=2 etc. into the set
		Iterator i = s.iterator(); // iterator over set so the i.next() contains a=0, they key and the value
		while (i.hasNext()){
			Map.Entry me = (Map.Entry)i.next(); // cast by map.entry so now me contains the key a and value 0
			return ((char) me.getKey());
		}
		return ch;
	}

}
