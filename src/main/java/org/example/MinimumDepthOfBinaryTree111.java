package org.example;

import org.example.helper.TreeNode;

public class MinimumDepthOfBinaryTree111 {
    public int minDepth(TreeNode root) {
        return recurse(root);
    }

    private int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recurse(root.left);
        int right = recurse(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return (Math.min(left, right) + 1);
    }
}
