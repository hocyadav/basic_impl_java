package sep17th;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/**
 * 
 * @author hariomyadav
 * https://www.youtube.com/watch?v=dh8ura4rVUM
 * https://www.baeldung.com/java-string-to-byte-array
 */
public class MessageDigest_halodoc {
	public static void main(String[] args) {
		String str = "hariom";
		
		String sha512Hash = getSha512Hash(str, "ABCD");
		System.out.println(sha512Hash);
	}
	
	public static String getSha512Hash(final String input, final String salt) {
        MessageDigest md;
        StringBuilder out = new StringBuilder();
        try {
            String algorithm = "SHA-512";//we can make it global
			md = MessageDigest.getInstance(algorithm);
            System.out.println(md.toString());
            
            md.update(salt.getBytes(Charset.defaultCharset()));
            byte[] mb2 = md.digest();
            printByteArray(mb2);
            
            md.update(input.getBytes(Charset.defaultCharset()));
            byte[] mb3 = md.digest();
            printByteArray(mb3);
            
            byte[] mb = md.digest();
            for (byte temp : mb) {
                String hexString = Integer.toHexString(temp);
				final StringBuilder stringBuilder = new StringBuilder(hexString);
				
                while (stringBuilder.length() < 2) {
                    stringBuilder.insert(0, "0");
                }
                String s = stringBuilder.toString();
                s = s.substring(s.length() - 2);
                out.append(s);
            }
        } catch (Exception e) {
            System.out.println("error in generating SHA 512 of String : {}, {}"+ input + e.getMessage());
        }
        return out.toString();
    }

	private static void printByteArray(byte[] bytes) {
		for (byte b : bytes) {
			System.out.print(b+" ");
		}
		System.out.println();
	}

}
/**
 * 
104 97 114 105 111 109 
charsetObj UTF-8
104 97 114 105 111 109 
hariom
hariom

 */
