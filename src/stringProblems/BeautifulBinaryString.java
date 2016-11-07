package stringProblems;

import java.util.*;

public class BeautifulBinaryString {
	
	private static boolean isMatch(char[] chars, char[] match, int currIndex) {
		for (int i = currIndex; i < currIndex + match.length; i++) {
			if (chars[i] != match[i - currIndex])
				return false;
		}
		return true;
	}
	
	private static int countChanges(String str) {
		char[] chars = str.toCharArray();
		char[] match = new char[] {'0', '1', '0'};
		int currMatchIndex = 0;
		
		int count = 0;
		boolean isSequence = false;
		
		for (int i = 0; i <= chars.length - match.length; i++) {

		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		String binaryString = scan.next();
		scan.close();
		
		System.out.println(binaryString.length() < 3 ? 0 : countChanges(binaryString));
	}
}
