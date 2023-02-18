package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Returns the two indices which sum to the target
     * O(n) runtime
     * O(n) space
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target - nums[i])) {
                return new int[]{memo.get(target - nums[i]), i};
            }

            memo.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }
}
