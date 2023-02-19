package org.example;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int runningDividend = makeNegative(dividend);
        int runningDivisor = makeNegative(divisor);
        boolean negative = dividend > 0 ^ divisor > 0;
        if (runningDivisor == -1) {
            return negative ? runningDividend : makePositive(dividend);
        }
        int count = 0;
        while (runningDividend < 0 && runningDividend <= runningDivisor) {
            runningDividend -= runningDivisor;
            count--;
        }
        return negative ? count : makePositive(count);
    }

    private int makeNegative(int a) {
        return a > 0 ? -a : a;
    }

    private int makePositive(int a) {
        if (a == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a > 0 ? a : -a;
    }
    public static void main(String[] args) {
        int count = new DivideTwoIntegers().divide(10, 3);
        System.out.println(count);
        System.out.println(new DivideTwoIntegers().divide(7, -3));
        System.out.println(new DivideTwoIntegers().divide(-7, -3));
        System.out.println(new DivideTwoIntegers().divide(-7, 3));
        System.out.println(new DivideTwoIntegers().divide(10, 10));
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, -1));
    }
}
