package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A better solution would not use the list
 * and instead compute the problemTreeNodes from the values as you go through them
 */
public class RecoverBinarySearchTree99 {
    private List<TreeNode> inorder = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        recurse(root);

        TreeNode firstProblem = null;
        TreeNode lastProblem = null;
        for (int i = 0; i < inorder.size(); i++) {
            int previousVal = i > 0 ? inorder.get(i - 1).val : Integer.MIN_VALUE;
            int nextVal = i < inorder.size() - 1 ? inorder.get(i + 1).val : Integer.MAX_VALUE;
            TreeNode node = inorder.get(i);
            if (node.val < previousVal || node.val > nextVal) {
                if (firstProblem == null) {
                    firstProblem = node;
                }
                lastProblem = node;
            }
        }

        int temp = firstProblem.val;
        firstProblem.val = lastProblem.val;
        lastProblem.val = temp;
    }

    private void recurse(TreeNode root) {
        if (root == null) {
            return;
        }

        recurse(root.left);
        inorder.add(root);
        recurse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node4;
        node4.left = node2;
        new RecoverBinarySearchTree99().recoverTree(root);
        System.out.println("resulting root" + root.val);
    }
}
