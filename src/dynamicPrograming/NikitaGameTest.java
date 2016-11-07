package dynamicPrograming;

import static org.junit.Assert.*;

import org.junit.Test;

public class NikitaGameTest {

	@Test
	public void testPlayNikitasGame() {
		assertEquals(NikitaGame.playNikitasGame(new int[] {4, 1, 1, 1, 1}), 3);
		assertEquals(NikitaGame.playNikitasGame(new int[] {0, 0, 0, 0}), 3);
		assertEquals(NikitaGame.playNikitasGame(new int[] {1, 1, 1, 1}), 2);
	}

}
