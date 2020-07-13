package july13th;

import java.time.LocalDateTime;

public class LocalDateTime_Ex {
	public static void main(String[] args) {
		LocalDateTime localDt = LocalDateTime.now();
		System.out.println(localDt);
		
		splitNMerge(localDt);
	}

	//input : 2020-07-13T18:14:50.362 --> output : 2020-07-13 18:14:50.362
	private static void splitNMerge(LocalDateTime localDt) {
		//in between T is there, split and store in array
		//then join with space
		String[] split = localDt.toString().split("T");
		for (String str : split) {
			System.out.println(str);
		}
		String join = String.join(" ", split);
//		System.out.println(join);/2020-07-13 18:14:50.362
	}
}
