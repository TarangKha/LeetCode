package Medium.Arrays;

public class LongestSubWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "pwwkew";
		String test2 = "abcabcbb";
		String test3 = "bbbb";
		String test4 = "aab";
		System.out.println(lengthOfLongestSubstring(test));
		System.out.println(lengthOfLongestSubstring(test2));
		System.out.println(lengthOfLongestSubstring(test3));
		System.out.println(lengthOfLongestSubstring(test4));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		boolean[] met = new boolean[128];
        int sublength = 0;
        int greatestSub = 0;
        for(int i=0;i<s.length();i++){
            int value = (int)s.charAt(i);
            if(met[value] == true){
            	if(s.charAt(i) != s.charAt(i-1)) {
            		sublength = greatestSub-1;
            	}
            } else {
                sublength++;
                met[value] = true;
                if(sublength > greatestSub){
                    greatestSub = sublength;
                }
            }
        }
        return greatestSub;
	}
	
	
}
