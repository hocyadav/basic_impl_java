package july29th;

public class SlidingWindow_sumGE_K {
	public static void main(String[] args) {
		String str = "abcabc";
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int sum = 21;
		slidingWindowGE_K(arr, sum);
	}

	//stable windows - sum till current
	//unstable - call in (if)while loop -> update result since GE, + try to make window stable
	private static void slidingWindowGE_K(int[] arr, int sum) {
		int windowSum = 0;
		int result = Integer.MAX_VALUE;
		int l = 0;
		for (int r = 0; r < arr.length; r++) {
			windowSum += arr[r];
			System.out.println("out - "+windowSum);
			while(l <= r && windowSum > sum ) {
				System.out.println("while - "+windowSum);
				result = Integer.min(result, r - l + 1);
				windowSum -= arr[l];//try to make window stable
				l++;
			}
		}
		System.out.println(result);
	}
}
