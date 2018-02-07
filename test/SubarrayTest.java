import misc.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SubarrayTest {

    private int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

    @Test
    public void testSubarraySum() {
        int expected = 6;
        int actual = Subarray.subarraySum(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaxSubarray() {
        int[] expected = { 4, -1, 2, 1 };
        int[] actual = Subarray.maxSubarray(input);

        assertArrayEquals(expected, actual);
    }
}
