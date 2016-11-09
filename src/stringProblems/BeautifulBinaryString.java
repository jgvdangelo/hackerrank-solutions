package stringProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BeautifulBinaryString {
	
	public static boolean isMatch(char[] chars, char[] match, int currIndex) {
		if (currIndex + match.length > chars.length)
			 return false;
		
		for (int i = currIndex; i < currIndex + match.length; i++) {
			if (chars[i] != match[i - currIndex])
				return false;
		}
		return true;
	}
	
	public static int countChanges(String str) {
		char[] chars = str.toCharArray();
		char[] match = new char[] {'0', '1', '0'};
		
		int count = 0;
		boolean isSequence = false;
		boolean isFirst = true;
		
		for (int i = 0; i <= chars.length - match.length; i++) {
			if (isMatch(chars, match, i)) {
				if (isFirst && !isSequence) {
					count++;
					isFirst = false;
				} else if (!isFirst && !isSequence) {
					// don't add to count
					isSequence = true;
				} else { // isSequence = true
					count++;
				}
				i += match.length - 2;
			} else { // is not a match
				isFirst = true;
				isSequence = false;
			}
		}
		return count;
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
		
		int len = scan.nextInt();
		String binaryString = scan.next();
		scan.close();
		
		// System.out.println(binaryString.length() < 3 ? 0 : countChanges(binaryString));
		System.out.println((binaryString.length() - binaryString.replaceAll("010", "").length())/3);
	}
}
