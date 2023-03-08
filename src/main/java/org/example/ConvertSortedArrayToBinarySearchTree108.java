package org.example;

import org.example.helper.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    private TreeNode recurse(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int currentIndex = (left + right) / 2;
        TreeNode current = new TreeNode(nums[currentIndex]);
        current.left = recurse(nums, left, currentIndex - 1);
        current.right = recurse(nums, currentIndex + 1, right);
        return current;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new ConvertSortedArrayToBinarySearchTree108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
}
