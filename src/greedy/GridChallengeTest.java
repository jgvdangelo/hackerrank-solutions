package greedy;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridChallengeTest {

	@Test
	public void testSwap() {
		char[] test = {'b', 'a'};
		GridChallenge.swap(test, 0, 1);
		assertArrayEquals(new char[] {'a','b'}, test);
	}

	@Test
	public void testBubbleSort() {
		char[] toTest = "gabriel".toCharArray();
		GridChallenge.bubbleSort(toTest);
		assertArrayEquals("abegilr".toCharArray(), toTest);
	}
	
	@Test
	public void testIsArrangeable() {
		char[][] toTest = {"xy".toCharArray(), "ba".toCharArray()};
		assertFalse(GridChallenge.isArrangeable(toTest));
	}
}
