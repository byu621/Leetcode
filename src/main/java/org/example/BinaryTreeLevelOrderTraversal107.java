package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        recurse(output, root, 0);
        Collections.reverse(output);
        return output;
    }

    private void recurse(List<List<Integer>> output, TreeNode current, int level) {
        if (current == null) {
            return;
        }

        if (output.size() == level) {
            output.add(new ArrayList<>());
        }

        output.get(level).add(current.val);
        recurse(output, current.left, level + 1);
        recurse(output, current.right, level + 1);
    }
}
