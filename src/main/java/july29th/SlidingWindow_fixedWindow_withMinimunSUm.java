package july29th;

public class SlidingWindow_fixedWindow_withMinimunSUm {
	public static void main(String[] args) {
		int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
		int fixedWindowSize = 3;
		slidingWindow_MinSUm(arr,fixedWindowSize);
	}

	//get 1st window size 
	//travers from k to len
	//get local sum and update min  local sum as result 
	private static void slidingWindow_MinSUm(int[] arr, int windowSize) {
		int result = Integer.MAX_VALUE;
		
		int firstWindowSum = 0;
		for (int i = 0; i < windowSize; i++)
			firstWindowSum += arr[i];
		
		int localSum = firstWindowSum;
		//int l = 0;//2 pointer its like rubber - one end is left and other end is right
		for (int r = windowSize; r < arr.length; r++) {
			localSum += (arr[r] - arr[r - windowSize]);
			result = Integer.min(result, localSum);//here we can store index also 
		}
		System.out.println("result "+result);
	}
}
//result 11