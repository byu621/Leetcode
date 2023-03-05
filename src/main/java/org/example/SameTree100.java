package org.example;

import org.example.helper.TreeNode;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recurse(p, q);
    }

    private boolean recurse(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null) {
            return (rootA == null) == (rootB == null);
        }

        if (rootA.val != rootB.val) {
            return false;
        }
        if (!recurse(rootA.left, rootB.left)) {
            return false;
        }
        if (!recurse(rootA.right, rootB.right)) {
            return false;
        }
        return true;
    }
}
