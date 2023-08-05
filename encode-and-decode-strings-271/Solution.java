
/**
 * LeetCode problem # 271, 'Encode and Decode Strings'
 * https://leetcode.com/problems/encode-and-decode-strings/
 */

import java.util.*;

class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) strs.size());
        for (String s : strs) {
            sb.append((char) s.length());
        }
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int curr = s.charAt(0);

        int[] lengths = new int[curr];
        for (int i = 0; i < curr; ++i) {
            lengths[i] = s.charAt(i + 1);
        }

        int start = curr + 1;
        for (int i = 0; i < curr; ++i) {
            list.add(s.substring(start, start + lengths[i]));
            start += lengths[i];
        }
        return list;
    }
}