package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        recurse(output, 0, root);
        return output;
    }

    private void recurse(List<List<Integer>> output, int level, TreeNode root) {
        if (root == null) {
            return;
        }

        if (level >= output.size()) {
            output.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            output.get(level).add(root.val);
        } else {
            output.get(level).add(0, root.val);
        }

        recurse(output, level + 1, root.left);
        recurse(output, level + 1, root.right);
    }
}
