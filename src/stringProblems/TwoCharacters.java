package stringProblems;

import java.util.*;

// from challenge here: https://www.hackerrank.com/challenges/two-characters
public class TwoCharacters {
	private static boolean isValidString(String str) {
		if (str.length() == 1 || str.length() == 0)
			return true;
		else if (str.length() == 2) {
			return str.charAt(0) != str.charAt(1);
		} else {
			char[] charStr = str.toCharArray();
			char evens = charStr[0];
			char odds = charStr[1];
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
	
	private static List<Character> findCharsMustBeRemoved(char[] str) {
		List<Character> mustRemove = new LinkedList<Character>();
		for (int i = 1; i < str.length; i++) {
			if (str[i] == str[i - 1] && !mustRemove.contains(str[i])) {
				mustRemove.add(str[i]);
			}
		}
		return mustRemove;
	}
	
	private static int findMinimumString(String str) {
		HashMap<Character, Integer> charSet = new HashMap<Character, Integer>();
		char[] string = str.toCharArray();
		for (int i = 0; i < string.length; i++) {
			if (!charSet.containsKey(string[i]))
				charSet.put(string[i], 1);
			else {
				charSet.put(string[i], charSet.get(string[i]) + 1);
			}
		}
		
		List<Character> mustRemove = findCharsMustBeRemoved(string);
		for (Character temp : mustRemove)
		{
			charSet.remove(temp);
			str.replace("" + temp, "");
		}
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		String str = scan.next();
		
		scan.close();
		
		System.out.println(isValidString(str) ? str : findMinimumString(str));
	}
}
