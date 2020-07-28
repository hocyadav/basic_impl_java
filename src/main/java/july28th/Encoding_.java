package july28th;

import java.util.Collections;
import java.util.List;

public class Encoding_ {
	
	public String enc(String msg, String key) {
		StringBuilder result = new StringBuilder();
		int l1 = msg.length();
		int l2 = key.length();
		int i = 0;
		while( (l1 > 0) && (l2 > 0) ) {
			int k = key.charAt(i) - '0';//get int , get string
			String s = String.valueOf(msg.charAt(i));
			
			String join = extracted(k, s);//actual logic
			result.append(join);
			
			l1--; l2--; i++;//update pointers
		}
		if(l1 > 0) {
			result.append(msg.substring(i));
		}
		return result.toString();
	}

	private String extracted(int k, String s) {
		List<String> nCopies = Collections.nCopies(k, s);
		String join = String.join("", nCopies);
		return join;
	}
}
