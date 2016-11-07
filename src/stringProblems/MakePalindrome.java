package stringProblems;

import java.util.*;

// from challenge here: https://www.hackerrank.com/challenges/richie-rich
public class MakePalindrome {

	public static String makeChanges(String number, int k) {
        char[] arr = number.toCharArray();
        int n = arr.length;
        
        Queue<Integer> unmatchedPairs = new LinkedList<Integer>();
        int counterpartIndex = 0;
        
        for (int i = 0; i < n / 2; i++) {
        	counterpartIndex = n - 1 - i;
        	if (arr[i] != arr[counterpartIndex]) {
        		unmatchedPairs.add(i);
        	}
        }
        
        if (k < unmatchedPairs.size()) {
        	return "-1";
        } else if (n == 1 && k > 0) {
    		arr[0] = '9';
        } else {
        	int currIndex = 0;
        	while (k > 0 && currIndex < n / 2) { 
    			if (k > unmatchedPairs.size()) {
					if (k - 2 >= unmatchedPairs.size()) {
						counterpartIndex = n - 1 - currIndex;
						if (arr[currIndex] != '9') {
							arr[currIndex] = '9';
							k--;
						}
						if (arr[counterpartIndex] != '9') {
							arr[counterpartIndex] = '9';
							k--;
						}
						if (unmatchedPairs.size() > 0 && unmatchedPairs.peek() == currIndex) {
							unmatchedPairs.remove();
						}
						currIndex++;
					} else {
						if (unmatchedPairs.size() > 0) {
							int remove = unmatchedPairs.remove();
							counterpartIndex = n - 1 - remove;
							if (arr[remove] != '9') {
								arr[remove] = '9';
								k--;
							}
							if (arr[counterpartIndex] != '9') {
								arr[counterpartIndex] = '9';
								k--;
							}
						} else {
							// can't do anything, break out of loop
							currIndex = n;
							continue;
						}
					}
    			} else { // if k == unmatchedPairs.size()
    				int check = unmatchedPairs.remove();
    				counterpartIndex = n - 1 - check;
    				if (arr[check] > arr[counterpartIndex]) {
    					arr[counterpartIndex] = arr[check];
    				} else {
    					arr[check] = arr[counterpartIndex];
    				}
    				k--;
    			}
        	}
        	if (k > 0 && n % 2 == 1) {
        		arr[n / 2] = '9';
        	}
        }
        return new String(arr);
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        
        System.out.println(makeChanges(number, k));
        
        in.close();
	}

}
