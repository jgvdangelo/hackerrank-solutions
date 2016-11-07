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

}
