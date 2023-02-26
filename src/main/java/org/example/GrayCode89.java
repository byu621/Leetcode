package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return recurse(list, n);
    }

    private List<Integer> recurse(List<Integer> list, int n) {
        if (list.size() == 1 << n) {
            if (oneDifference(list.get(0), list.get(list.size() - 1), n)) {
                return list;
            }
            return null;
        }

        int last = list.get(list.size() - 1);
        for (int i = 0; i < n; i++) {
            int flippedBit = last ^ (1 << i);
            if (list.contains(flippedBit)) {
                continue;
            }
            list.add(flippedBit);
            if (recurse(list, n) != null) {
                return list;
            }
            list.remove(list.size() - 1);
        }
        return null;
    }

    private boolean oneDifference(int a, int b, int n) {
        String first = Integer.toBinaryString(a + (1 << n)).substring(1);
        String last = Integer.toBinaryString(b + (1 << n)).substring(1);
        int difference = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                difference++;
            }
        }
        return difference == 1;
    }
    public static void main(String[] args) {
        List<Integer> integers = new GrayCode89().grayCode(1);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
