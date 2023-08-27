
/**
 * LeetCode problem # 68, 'Text Justification'
 * https://leetcode.com/problems/text-justification/
 */

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;

        int index = 0;
        while (index < n) {
            int count = words[index].length();
            int last = index + 1;

            while (last < n) {
                int m = words[last].length();
                if (m + count + 1 > maxWidth) {
                    break;
                }
                count += (m + 1);
                ++last;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;

            if (last == n || diff == 0) {
                for (int i = index; i < last; ++i) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; ++i) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;

                for (int i = index; i < last; ++i) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); ++j) {
                            sb.append(" ");
                        }
                    }
                }
            }

            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}