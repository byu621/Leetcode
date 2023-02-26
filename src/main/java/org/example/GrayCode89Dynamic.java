package org.example;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89Dynamic {
    public List<Integer> grayCode(int n) {
        return recurse(n);
    }

    private List<Integer> recurse(int n) {
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }

        List<Integer> list = recurse(n - 1);
        int listSize = list.size();
        for (int i = listSize - 1; i >= 0; i--) {
            int toAdd = list.get(i) ^ (1 << (n - 1));
            list.add(toAdd);
        }
        return list;
    }
    public static void main(String[] args) {
        List<Integer> integers = new GrayCode89Dynamic().grayCode(3);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
