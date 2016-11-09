package greedy;

import java.util.*;

// from challenge here: https://www.hackerrank.com/challenges/luck-balance

public class LuckBalance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int balance = 0;
		
		int luck = 0;
		int imp = 0;
		
		List<Integer> importantScores = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			luck = scan.nextInt(); 
			imp = scan.nextInt();
			
			if (imp == 0) {
				balance += luck;
			} else { // if imp == 1
				importantScores.add(luck);
			}
		}
		
		Collections.sort(importantScores, Collections.reverseOrder());
		
		while (!importantScores.isEmpty() && k > 0) {
			balance += importantScores.remove(0);
		}
		
		while (!importantScores.isEmpty()) {
			balance -= importantScores.remove(0);
		}
		
		scan.close();
	}
}
