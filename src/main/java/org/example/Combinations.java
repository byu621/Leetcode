package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        recurse(new ArrayList<>(), n, k, output);
        return output;
    }

    private void recurse(List<Integer> current, int n, int k, List<List<Integer>> output) {
        if (current.size() == k) {
            output.add(new ArrayList<>(current));
            return;
        }

        int currentLargest = current.size() > 0 ? current.get(current.size() - 1) : 0;
        for (int i = currentLargest + 1; i <= n; i++) {
            current.add(i);
            recurse(current, n, k, output);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(5, 3);
    }
}
