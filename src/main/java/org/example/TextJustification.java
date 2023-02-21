package org.example;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        int l = 0, r = 1; // r is exclusive
        while (r <= words.length) {
            int length = words[r - 1].length();
            while (r < words.length && length + words[r].length() + 1 <= maxWidth) {
                length += words[r++].length() + 1;
            }
            int numberOfWords = r - l;
            int numberOfSpaces = r - l - 1;
            int spaceLength = maxWidth - length + numberOfSpaces;
            int initialLength = numberOfSpaces > 0 ? (int) Math.ceil((double) spaceLength / numberOfSpaces) : 0;
            int otherLength = numberOfSpaces > 1 ? (spaceLength - initialLength) / (numberOfSpaces - 1) : 0;
            if (r == words.length) {
                initialLength = 1;
                otherLength = 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = l; i < r; i++) {
                sb.append(words[i]);
                if (otherLength * (r - i - 1) < spaceLength) {
                    spaceLength -= initialLength;
                    sb.append(" ".repeat(initialLength));
                } else if (i < r - 1) {
                    spaceLength -= otherLength;
                    sb.append(" ".repeat(otherLength));
                }
            }
            if (r == words.length || numberOfWords == 1) {
                sb.append(" ".repeat(maxWidth - sb.length()));
            }
            output.add(sb.toString());
            l = r;
            r++;
        }
        return output;
    }

    public static void main(String[] args) {
        new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        new TextJustification().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
    }
}
