package org.example;

import org.example.helper.TreeNode;

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        return recurse(root) != -1;
    }

    private int recurse(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = recurse(current.left);
        int right = recurse(current.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        int difference = left - right;
        if (Math.abs(difference) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
