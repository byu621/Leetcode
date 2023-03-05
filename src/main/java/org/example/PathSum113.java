package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(res, new ArrayList<>(), root, 0, targetSum);
        return res;
    }

    private void recurse(List<List<Integer>> res, List<Integer> current, TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                current.add(root.val);
                res.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
            return;
        }

        current.add(root.val);
        recurse(res, current, root.left, sum + root.val, targetSum);
        recurse(res, current, root.right, sum + root.val, targetSum);
        current.remove(current.size() - 1);
    }
}
