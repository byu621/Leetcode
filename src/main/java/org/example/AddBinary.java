package org.example;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        while (aPointer >= 0 || bPointer >= 0) {
            int firstValue = aPointer >= 0 ? a.charAt(aPointer) - '0' : 0;
            int secondValue = bPointer >= 0 ? b.charAt(bPointer) - '0' : 0;
            int sumValue = firstValue + secondValue + carry;
            sb.append(sumValue % 2);
            carry = sumValue / 2;
            aPointer--;
            bPointer--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("100" , "101"));
    }
}
