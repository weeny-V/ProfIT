package tasks.first;

import java.util.Arrays;
import java.util.Collections;

public class PositiveSortedArray {
    public static Integer[] getOdds(Integer[] nums) {
        if (nums == null) {
            return new Integer[]{};
        }

        return Arrays.stream(nums)
                .filter(num -> num >= 0)
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
    }
}
