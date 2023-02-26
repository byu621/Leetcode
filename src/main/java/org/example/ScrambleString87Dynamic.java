package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrambleString87Dynamic {
    private Map<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return recurse(s1, s2);
    }

    private boolean recurse(String s, String target) {
        if (s.length() == 1) {
            return s.equals(target);
        }

        String memoString = s + ":" + target;
        if (memo.containsKey(memoString)) {
            return memo.get(memoString);
        }

        for (int j = 1; j < s.length(); j++) {
            String left = s.substring(0, j);
            String right = s.substring(j);
            String targetLeft = target.substring(0,j);
            String targetRight = target.substring(j);
            String targetLeftOther = target.substring(0, s.length() - j);
            String targetRightOther = target.substring(s.length() - j);
            if (recurse(left, targetLeft) && recurse(right, targetRight) || recurse(right, targetLeftOther) && recurse(left, targetRightOther)) {
                memo.put(memoString, true);
                return true;
            }
        }
        memo.put(memoString, false);
        return false;
    }

    public static void main(String[] args) {
        boolean output = new ScrambleString87Dynamic().isScramble("great", "rgeat");
//        boolean output = new ScrambleString87Dynamic().isScramble("abcdbdacbdac", "bdacabcdbdac");
        System.out.println(output);
    }
}
