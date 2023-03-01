package org.example;

import java.util.*;

public class Subsets90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        recurse(new ArrayList<>(), res, nums, 0);
        return res;
    }

    private void recurse(List<Integer> current, List<List<Integer>> res, int[] nums, int iteration) {
        if (iteration == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[iteration]);
        recurse(current, res, nums, iteration + 1);
        current.remove(current.size() - 1);
        int currentNum = nums[iteration];
        while (iteration < nums.length && nums[iteration] == currentNum) {
            iteration++;
        }
        recurse(current, res, nums, iteration);
    }
    public static void main(String[] args) {
        System.out.println(new Subsets90().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
