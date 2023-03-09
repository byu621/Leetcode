package org.example;

import org.example.helper.TreeNode;

public class FlattenBinaryTreeToLinkedList114 {
    /**
     * Preorder
     * me
     * left
     * right
     *
     * the better solution would be to work your way bottom up instead of top bottom
     */
    public void flatten(TreeNode root) {
        recurse(root, new TreeNode());
    }

    private TreeNode recurse(TreeNode current, TreeNode prev) {
        if (current == null) {
            return prev;
        }

        TreeNode leftTree = current.left;
        TreeNode rightTree = current.right;

        current.left = null;
        prev.right = current;

        TreeNode leftLeftover = recurse(leftTree, current);
        TreeNode rightLeftover = recurse(rightTree, leftLeftover);
        return rightLeftover;
    }
}
