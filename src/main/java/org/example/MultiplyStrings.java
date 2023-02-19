package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<Integer> list = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int bNum = num2.charAt(i) - '0';
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int positionInList = num2.length() - 1 - i + num1.length() - 1 - j;
                if (positionInList == list.size()) {
                    list.add(0);
                }
                int tNum = num1.charAt(j) - '0';
                int value = bNum * tNum + carry;
                carry = value / 10;
                int previousValue = list.get(positionInList);
                int newValue = previousValue + value % 10;
                list.set(positionInList, newValue);
            }
            if (carry != 0) {
                list.add(carry);
            }
        }
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int newValue = value + carry;
            list.set(i, newValue % 10);
            carry = newValue / 10;
        }
        if (carry != 0) {
            list.add(carry);
        }
        Collections.reverse(list);
        StringBuilder res = new StringBuilder();
        for (int i : list) {
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
