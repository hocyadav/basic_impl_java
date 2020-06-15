package june13th;

import java.util.HashMap;
import java.util.Map;

//logic : Map + 2 pointer --> traverse (Add in map + Check in map + update max longest)
public class LongestSubstring_IN_STRING_1_2_or_K_Different {
	public static void main(String[] args) {
		String str = "abcabcabcaaaaaa";
		int result = longestSubstring_kDifferent_Try1(str);
		System.out.println(result);
		
		int r = longestSubstring_kDifferent_Try2(str);
		System.out.println(r);
	}

	//this will count how many unique char
	private static int longestSubstring_kDifferent_Try1(String str) {
		//null check
		if(str.length() == 0) {
			return 0;
		}
		
		//1. Map + 2 pointer
		Map<Character, Integer> map = new HashMap();
		int l = 0;
		
		//2. traverse (add/put in map + check map + update max)
		for (int r = 0; r < str.length(); r++) {
			Integer count = map.getOrDefault(str.charAt(r), 0);
			map.put(str.charAt(r), count+1);
			
			//result = Math.max(result, r - l + 1);
		}
		System.out.println(map);
		return map.size();
	}
	
	
	//we want limit of 2 uniq char max size --> so check map size
	private static int longestSubstring_kDifferent_Try2(String str) {
		int result = 0;
		//null check
		if(str.length() == 0) {
			return 0;
		}
		
		//1. Map + 2 pointer
		Map<Character, Integer> map = new HashMap();
		int l = 0;
		
		//2. traverse (add/put in map + check map + update max)
		for (int r = 0; r < str.length(); r++) {
			Integer count = map.getOrDefault(str.charAt(r), 0);
			map.put(str.charAt(r), count+1);
			
			
			if(map.size() > 2) {//not excedding map size + in that size we will calculate longest lenght in given string
				while(l < str.length() && map.size() > 2) {//l pointer check is special check
					int c = map.get(str.charAt(l));
					map.put(str.charAt(l), c  - 1);
					if(map.get(str.charAt(l)) == 0) {
						map.remove(str.charAt(l));
					}
					l++;
				}
			}
			
			
			result = Math.max(result, r - l + 1);
		}
		System.out.println(map);
		return map.size();
	}
	
	
}
