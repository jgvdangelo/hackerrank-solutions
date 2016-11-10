package stringProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// from challenge here: https://www.hackerrank.com/challenges/two-characters
public class TwoCharacters {
	private static boolean isValidString(String str) {
		if (str.length() == 1 || str.length() == 0)
			return false;
		else if (str.length() == 2) {
			return str.charAt(0) != str.charAt(1);
		} else {
			char[] charStr = str.toCharArray();
			char evens = charStr[0];
			char odds = charStr[1];
			if (evens == odds)
				return false;
			char toCompare;
			for (int i = 2; i < charStr.length; i++) {
				if (i % 2 == 1) 
					toCompare = odds;
				else
					toCompare = evens;
				
				if (charStr[i] != toCompare)
					return false;
			}
			return true;
		}
	}
	
	private static void updateCounts(int letter, int[][] letters, int[][] counts) {
		
		for (int i = 0; i < letters.length; i++) {
			if (i != letter) {
				if (letters[letter][i] == letter) {
					counts[letter][i] = -1;
				} else if (counts[letter][i] != -1) {
					counts[letter][i] = counts[letter][i] + 1;
				}
				
				if (letters[i][letter] == letter) {
					counts[i][letter] = -1;
				} else if (counts[i][letter] != -1) {
					counts[i][letter] = counts[i][letter] + 1;
				}
			} 
			
			// set row
			letters[letter][i] = letter;
			//set column
			letters[i][letter] = letter;
		}
	
	}
		
	private static int findMaximumString(String str) {
		if (str.length() == 1 || str.length() == 0)
			return 0;
		
		str.toLowerCase();
		
		// creating a matrix for each letter combination
		int[][] letters = new int[26][];
		// creating a matrix to check the letter combination counts that occur
		int[][] letterCounts = new int[26][]; 
		
		// initialize all to -1
		for (int i = 0; i < letters.length; i++) {
			letters[i] = new int[26];
			Arrays.fill(letters[i], -1);
			
			letterCounts[i] = new int[26];
		}
		
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++){
			updateCounts(chars[i] - 'a', letters, letterCounts);
		}
		
		// find max in counts matrix
		int max = -1;
		for (int i = 0; i < letterCounts.length; i++) {
			for (int j = 0; j < letterCounts.length; j++) {
				if (letterCounts[i][j] > max) {
					max = letterCounts[i][j];
				}
			}
		}
		
		return max;
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
		
		int length = scan.nextInt();
		String str = scan.next();
		
		scan.close();
		
		System.out.println(isValidString(str) ? str.length() : findMaximumString(str));
	}
}
