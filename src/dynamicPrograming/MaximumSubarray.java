package dynamicPrograming;

import java.util.*;

public class MaximumSubarray {
	private static int contiguousHelper(int[] arr, int currIndex, int indexStart, int sumSoFar) {
		if (indexStart == -1) {
			int startHere = contiguousHelper(arr, currIndex, currIndex, 0);
			if (currIndex + 1 < arr.length) {
				int startNext = contiguousHelper(arr, currIndex + 1, indexStart, sumSoFar);
				return Math.max(startHere, startNext);
			}
			return startHere;
		} else {
			sumSoFar += arr[currIndex];
			int withoutNext = sumSoFar;
			if (currIndex + 1 < arr.length) {
				int withNext = contiguousHelper(arr, currIndex + 1, indexStart, sumSoFar);
				return Math.max(withoutNext, withNext);
			}
			return withoutNext;
		}
	}
	
	private static int fasterContHelper(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		
		int maxSumSoFar = 0;
		int currSum = maxSumSoFar;
		
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum < 0) {
				currSum = 0;
			} else if (maxSumSoFar < currSum) {
				maxSumSoFar = currSum;
			}
		}
		
		if (maxSumSoFar == 0) { // if all values are negative or zero
			maxSumSoFar = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > maxSumSoFar)
					maxSumSoFar = arr[i];
			}
		}
		
		return maxSumSoFar;
	}
	
	public static int maxSumContiguous(int[] arr) {
		// NOTE: Commenting out this method, since it is O(2^N) and not faster!
		// return contiguousHelper(arr, 0, -1, 0);
		
		return fasterContHelper(arr);
	}
	
	private static int nonContiguousHelper(int[] arr, int startIndex, int currIndex, int sumSoFar) {
		if (startIndex == -1) {
			if (currIndex == arr.length - 1) {
				return arr[currIndex];
			} else {
				int start = nonContiguousHelper(arr, currIndex, currIndex + 1, arr[currIndex]);
				int noStart = nonContiguousHelper(arr, startIndex, currIndex + 1, sumSoFar);
				return Math.max(start, noStart);
			}
		} else if (currIndex >= arr.length) {
			return sumSoFar;
		} else {
			int with = nonContiguousHelper(arr, startIndex, currIndex + 1, sumSoFar + arr[currIndex]);
			int without = nonContiguousHelper(arr, startIndex, currIndex + 1, sumSoFar);
			return Math.max(with, without);
		}
	}
	
	private static int fasterNonContHelper(int[] arr) {
		int sum = 0; // minimum value to be returned, empty subarray
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0)
				sum+= arr[i];
		}
		
		if (sum == 0) { // if all values are negative or zero
			sum = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > sum)
					sum = arr[i];
			}
		}

		return sum;
	}
	
	public static int maxSumNonContiguous(int[] arr) {
		// NOTE: Commenting out this method, since it is O(2^N) and not faster!
		// return nonContiguousHelper(arr, -1, 0, 0);
		
		return fasterNonContHelper(arr);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		int length = 0;
		int[] arr = null;
		
		for (int i = 0; i < cases; i++) {
			length = scan.nextInt();
			arr = new int[length];
			
			for (int j = 0; j < length; j++) {
				arr[j] = scan.nextInt();
			}			
			
			System.out.println(maxSumContiguous(arr) + " " + maxSumNonContiguous(arr));
		}
		
		scan.close();
	}
}
