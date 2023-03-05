package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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

        output.get(level).add(root.val);

        recurse(output, level + 1, root.left);
        recurse(output, level + 1, root.right);
    }
}
