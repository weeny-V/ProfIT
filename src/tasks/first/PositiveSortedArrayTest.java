package tasks.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveSortedArrayTest {
    @Test
    void onlyNegativeValues() {
        Assertions.assertArrayEquals(new Integer[]{}, PositiveSortedArray.getOdds(new Integer[]{ -1, -2, -3, -4 }));
    }

    @Test
    void onlyPositiveValues() {
        Assertions.assertArrayEquals(new Integer[]{ 5, 4, 3, 2, 1 }, PositiveSortedArray.getOdds(new Integer[]{ 1, 2, 3, 4, 5 }));
    }

    @Test
    void negativeAndPositiveValues() {
        Assertions.assertArrayEquals(new Integer[]{ 70, 57, 42, 13, 2 }, PositiveSortedArray.getOdds(new Integer[]{ -1, -15, 70, -55, 2, 13, -93, -17,57, -1, 42 }));
    }

    @Test
    void nullTest() {
        Assertions.assertNotNull(PositiveSortedArray.getOdds(null));
    }
}
