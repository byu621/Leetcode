package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * This solution doesn't work.
 * But I'm leaving it here as a reminder that things don't always work on the firs try
 */
public class ScrambleString87 {
    public boolean isScramble(String s1, String s2) {
        List<String> list = new ArrayList<>();
        list.add(s1);
        return recurse(list, s1, s2);
    }

    private boolean recurse(List<String> current, String original, String target) {
        int startingSize = current.size();
        if (startingSize == original.length()) {
            StringBuilder sb = new StringBuilder();
            for (String s : current) {
                sb.append(s);
            }

            return sb.toString().equals(target);
        }

        int targetPointer = 0;
        for (String segment : current) {
            if (segment.length() == 1 && target.charAt(targetPointer) != segment.charAt(0)) {
                return false;
            }

            targetPointer += segment.length();
        }

        boolean output = false;
        for (int i = 0; i < startingSize; i++) {
            String s = current.get(i);
            if (s.length() == 1) {
                continue;
            }
            for (int j = 1; j < s.length(); j++) {
                String left = s.substring(0, j);
                String right = s.substring(j);
                output |= executePath(current, left, right, i, s, original, target);
                if (output) {
                    return true;
                }
                output |= executePath(current, right, left, i, s, original, target);
                if (output) {
                    return true;
                }
            }
        }

        return output;
    }

    private boolean executePath(List<String> current, String first, String second, int i, String s, String original, String target) {
        current.remove(i);
        current.add(i, first);
        current.add(i + 1, second);
        boolean output = recurse(current, original, target);
        current.remove(i + 1);
        current.remove(i);
        current.add(i, s);
        return output;
    }

    public static void main(String[] args) {
//        boolean output = new ScrambleString87().isScramble("great", "rgeat");
        boolean output = new ScrambleString87().isScramble("abcdbdacbdac", "bdacabcdbdac");
        System.out.println(output);
    }
}
