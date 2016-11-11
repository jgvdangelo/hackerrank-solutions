package stringProblems;

import java.util.*;

public class AlternatingCharacters {
	public static void processCase(String str) {
		if (str.length() == 1) {
			System.out.println("0");
		} else {
			char[] chars = str.toCharArray();
			int count = 0;
			
			for (int i = 0; i < str.length() - 1; i++) {
				if (chars[i] == chars[i+1])
					count++;
			}
			
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		
		for (int i = 0; i < cases; i++) {
			processCase(scan.next());
		}
		
		scan.close();
	}
}
