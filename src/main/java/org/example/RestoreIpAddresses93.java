package org.example;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recurse(res, "", s, 0);
        return res;
    }

    private void recurse(List<String> res, String pre, String rest, int dot) {
        if (rest.isEmpty()) {
            if (dot == 4) {
                res.add(pre.substring(1));
            }
            return;
        }

        for (int i = 1; i <= 3 && i <= rest.length(); i++) {
            String substring = rest.substring(0, i);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                return;
            }
            int intRepresentation = Integer.parseInt(substring);
            if (intRepresentation <= 255) {
                recurse(res, pre + "." + substring, rest.substring(i), dot + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses93().restoreIpAddresses("25525511135"));
    }
}
