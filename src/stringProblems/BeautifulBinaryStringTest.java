package stringProblems;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeautifulBinaryStringTest {

	@Test
	public void testIsMatch() {
		char[] match = new char[] {'0', '1', '0'};
		char[] toMatch = {'0', '1', '0', '1', '0', '1'};
		
		assertTrue(BeautifulBinaryString.isMatch(toMatch, match, 0));
		assertFalse(BeautifulBinaryString.isMatch(toMatch, match, 4));
		assertTrue(BeautifulBinaryString.isMatch(toMatch, match, 2));
	}

	@Test
	public void testCountChanges() {
		assertEquals(BeautifulBinaryString.countChanges("01010"),1);
		assertEquals(BeautifulBinaryString.countChanges("0101010"),2);
		assertEquals(BeautifulBinaryString.countChanges("0"),0);
		assertEquals(BeautifulBinaryString.countChanges("100001"),0);
		assertEquals(BeautifulBinaryString.countChanges("010010010"),3);
		assertEquals(BeautifulBinaryString.countChanges("010"),1);
		assertEquals(BeautifulBinaryString.countChanges("010101010"),3);
	}

}
