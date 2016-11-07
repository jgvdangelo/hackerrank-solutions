package stringProblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakePalindromeTest {

	@Test
	public void testMakeChanges() {
		//// testing when k = # of unmatched pairs
		assertEquals("98789", MakePalindrome.makeChanges("98788", 1));
		assertEquals("88788", MakePalindrome.makeChanges("78788", 1));
		assertEquals("99", MakePalindrome.makeChanges("39", 1));
		
		//// testing when k - 1 = # of unmatched pairs 
		// where unmatched pairs are present
		assertEquals("99", MakePalindrome.makeChanges("63", 2));
		assertEquals("92429", MakePalindrome.makeChanges("12427", 2));
		assertEquals("93439", MakePalindrome.makeChanges("12437", 3));
		// where unmatched pairs are not present
		assertEquals("797", MakePalindrome.makeChanges("737", 1));
		assertEquals("9", MakePalindrome.makeChanges("3", 1));
		
		//// testing when k - 2 >= # of unmatched pairs
		assertEquals("992299", MakePalindrome.makeChanges("092282", 4));
		assertEquals("9929299", MakePalindrome.makeChanges("0921282", 4));
		assertEquals("992299", MakePalindrome.makeChanges("932239", 2));
	}

}
