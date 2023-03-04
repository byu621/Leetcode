package org.example;

import org.example.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Note you can use a startIndex and an endIndex instead of list as your list is guaranteed to be sequential
 */
public class UniqueBinarySearchTrees95 {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> possibilities = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            possibilities.add(i);
        }
        List<TreeNode> res = recurse(possibilities);
        return res;
    }

    private List<TreeNode> recurse(List<Integer> list) {
        if (list.size() == 1) {
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(list.get(0)));
            return res;
        }

        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> leftList = list.subList(0, i);
            List<TreeNode> left = recurse(leftList);

            List<Integer> rightList = list.subList(i + 1, list.size());
            List<TreeNode> right = recurse(rightList);
            if (left.size() == 0) {
                left.add(null);
            }
            if (right.size() == 0) {
                right.add(null);
            }
            for (TreeNode rightNode : right) {
                for (TreeNode leftNode : left) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees95().generateTrees(3));
    }
}
