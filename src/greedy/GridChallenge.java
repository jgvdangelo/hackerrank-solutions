package greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//from challenge here: https://www.hackerrank.com/challenges/grid-challenge
public class GridChallenge {
	
	public static void swap(char[] array, int ind1, int ind2) {
		char temp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = temp;
	}
	
	private static boolean isSorted(char[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1])
				return false;
		}
		return true;
	}
	
	public static void bubbleSort(char[] array) {
		int endIndex = array.length;
		while (!isSorted(array)) {
			
			for (int i = 0; i < endIndex - 1; i++) {
				if ((int) array[i] > (int) array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
			
			endIndex--;
		}
	}
	
	public static boolean isArrangeable(char[][] grid) {
		if (grid.length == 1)
			return true;

		// perform bubble sort on each as, as it's implied by the problem statement
		// (and also for good practice). We would not actually use 
		// bubble-sort if this was a real program!
		for (int i = 0; i < grid.length; i++) {
			bubbleSort(grid[i]);
		}
		
		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = 0; j < grid.length; j++) {
				if ((int)grid[i][j] > (int)grid[i + 1][j])
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = null;
		
		if (args != null && args.length > 0 && args[0].equals("-d")) {
			try {
				scan = new Scanner(new File(args[1]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				scan = new Scanner(System.in);
			}
		} else {
			scan = new Scanner(System.in);
		}
		
		int testCases = scan.nextInt();
		
		// initialize loop variables
		int length = 0;
		String line = null;
		
		char[][] grid;
		
		for (int k = 0; k < testCases; k++) {
			length = scan.nextInt();
			grid = new char[length][];
			
			for (int i = 0; i < length; i++) {
				line = scan.next();
				grid[i] = line.toCharArray();
			}
			System.out.println(isArrangeable(grid) ? "YES" : "NO");
		}

		scan.close();
	}
	
}
