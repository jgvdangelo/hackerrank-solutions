package stringProblems;

import java.util.*;

public class SuperReducedString {
	
	private static void reduce(String str) {
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				str = str.substring(0, i - 1) + str.substring(i + 1, str.length());
				i = 0;
			}
		}
		
		// print the reduced output
		if (str.isEmpty()) {
			System.out.println("Empty String");
		} else {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String toReduce = scan.next();
		
		reduce(toReduce);
		
		scan.close();
	}

}
