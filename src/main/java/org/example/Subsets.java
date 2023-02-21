package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> output = new ArrayList<>();
        recurse(new ArrayList<>(), 0, nums, output);
        return output;
    }

    private void recurse(List<Integer> current, int start, int[] nums, List<List<Integer>> output) {
        if (start == nums.length) {
            output.add(new ArrayList<>(current));
            return;
        }

        List<Integer> addList = new ArrayList<>(current);
        addList.add(nums[start]);

        recurse(addList, start + 1, nums, output);
        recurse(current, start + 1, nums, output);
    }

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }
}
