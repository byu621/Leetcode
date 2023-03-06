package org.example;

import org.example.helper.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    /**
     * Using recursion would be better. Glad I got a solution
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int a = 1;
        int b = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        while (a < preorder.length && b < inorder.length) {
            TreeNode next = new TreeNode(preorder[a]);
            if (stack.peek().val == inorder[b]) {
                b++;
                int finalB = b;
                if (stack.stream().anyMatch(e -> e.val == inorder[finalB])) {
                    while (stack.peek().val != inorder[b]) {
                        stack.pop();
                    }
                    continue;
                }
                stack.peek().right = next;
                stack.push(next);
                a++;
                continue;
            }

            stack.peek().left = next;
            stack.push(next);
            a++;
        }
        return root;
    }
}
