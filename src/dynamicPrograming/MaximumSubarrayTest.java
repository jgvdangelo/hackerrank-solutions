package dynamicPrograming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumSubarrayTest {

	@Test
	public void testMaxSumContiguous() {
		int[] test1 = new int[] {1, 2, 3, 4};
		assertEquals(MaximumSubarray.maxSumContiguous(test1), 10);
		
		int[] test2 = new int[] {2, -1, 2, 3, 4, -5};
		assertEquals(MaximumSubarray.maxSumContiguous(test2), 10);
		
		int[] test3 = new int[] {1};
		assertEquals(MaximumSubarray.maxSumContiguous(test3), 1);
		
		int[] test4 = new int[] {-1, -2, -3, -4, -5};
		assertEquals(MaximumSubarray.maxSumContiguous(test4), -1);
	}

	@Test
	public void testMaxSumNonContiguous() {
		int[] test1 = new int[] {1, 2, 3, 4};
		assertEquals(MaximumSubarray.maxSumNonContiguous(test1), 10);
		
		int[] test2 = new int[] {2, -1, 2, 3, 4, -5};
		assertEquals(MaximumSubarray.maxSumNonContiguous(test2), 11);
		
		int[] test3 = new int[] {1};
		assertEquals(MaximumSubarray.maxSumContiguous(test3), 1);
		
		int[] test4 = new int[] {-1, -2, -3, -4, -5};
		assertEquals(MaximumSubarray.maxSumContiguous(test4), -1);
	}

}
