package dynamicPrograming;

import java.util.*;
import java.io.*;

// from challenge here: https://www.hackerrank.com/challenges/array-splitting

public class NikitaGame {
	
	// helper method, that calculates the sum of all values in the
	// the array 'arr'
	private static long arraySum(int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (long) arr[i];
		}
		return sum;
	}
	
	@SuppressWarnings("unused")
	private static int recursiveHelper(int[] arr, int startInd, int endInd, long totalSum) { 
		if (totalSum % 2 == 1 || startInd == endInd) {
			return 0;
		}
		// TODO: think of how 0's cause there to be multiple pivot points!
		long sumSoFar = 0;
		for (int i = startInd; i < endInd; i++) {
			sumSoFar += (long) arr[i];
			if (sumSoFar == totalSum / 2) {
				int left = recursiveHelper(arr, startInd, i, totalSum / 2);
				int right = recursiveHelper(arr, i + 1, endInd, totalSum / 2);
				return 1 + Math.max(left, right);
			} else if (sumSoFar > totalSum / 2) {
				// cannot be pivoted
				return 0;
			}
		}
	
		return 0;
	}
	
	public static int dynamicProgramingHelper(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}
		
		int[][] dpTable = new int[arr.length][];
		
		for (int i = 0; i < dpTable.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j == i) {
					dpTable[i][j] = 0;
				} else {
					
				}
			}
		}
		return 0;
	}
	
	public static int playNikitasGame(int[] arr) {
		long arrayTotal = arraySum(arr);
		if (arrayTotal == 0) {
			return arr.length - 1;
		} else {
			// commenting out my own version, so as to write a version with DP.
			// return recursiveHelper(arr, 0, arr.length - 1, arrayTotal);
			
			return dynamicProgramingHelper(arr);
		}
	}
	
	public static void main(String[] args) {

		Scanner scanner;
		
		if (args != null && args.length > 0 && args[0].equals("-d")) {
			try {
				scanner = new Scanner(new File(args[1]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				scanner = new Scanner(System.in);
			}
		} else {
			scanner = new Scanner(System.in);
		}
		
		int totalCases = scanner.nextInt();
		int[] arr = null;
		int arrSize = 0;
		
		for (int i = 0; i < totalCases; i++) {
			arrSize = scanner.nextInt();
			arr = new int[arrSize];
			for (int j = 0; j < arrSize; j++) {
				arr[j] = scanner.nextInt();				
			}
			System.out.println(playNikitasGame(arr));
		}
		
		scanner.close();
	}
	
}
