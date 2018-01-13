import org.junit.Before;
import org.junit.Test;
import sorting.*;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {

    private int[] input = { 27, 29, 26, 5, 9, 3, 7, 1, 90, 557, 937, 28 };
    private int[] expected;
    private int[][] copies;
    private int curr = 0;

    @Before
    public void setup() {
        expected = Arrays.copyOfRange(input, 0, input.length);
        Arrays.sort(expected);

        int algos = 6;
        copies = new int[algos][input.length];

        for(int i = 0; i < algos; i++) {
            copies[i] = Arrays.copyOfRange(input, 0, input.length);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] in = copies[curr++];

        BubbleSort.sort(in);
        assertArrayEquals(expected, in);
    }

    @Test
    public void testInsertionSort() {
        int[] in = copies[curr++];

        InsertionSort.sort(in);
        assertArrayEquals(expected, in);
    }

    @Test
    public void testSelectionSort() {
        int[] in = copies[curr++];

        SelectionSort.sort(in);
        assertArrayEquals(expected, in);
    }

    @Test
    public void testQuickSort() {
        int[] in = copies[curr++];

        QuickSort.sort(in);
        assertArrayEquals(expected, in);
    }

    @Test
    public void testMergeSort() {
        int[] in = copies[curr++];

        MergeSort.sort(in);
        assertArrayEquals(expected, in);
    }

    @Test
    public void testHeapSort() {
        int[] in = copies[curr++];

        HeapSort.sort(in);
        assertArrayEquals(expected, in);
    }
}
