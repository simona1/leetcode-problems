
/**
 * LeetCode problem # 2194, 'Cells in a Range on an Excel Sheet'
 * https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet
 */

import java.util.*;

class Solution {
    public List<String> cellsInRange(String s) {
        int start = s.charAt(1) - '0';
        int end = s.charAt(4) - '0';

        char colStart = s.charAt(0);
        char colEnd = s.charAt(3);

        List<String> res = new ArrayList<>();

        for (char c = colStart; c <= colEnd; ++c) {
            for (int i = start; i <= end; ++i) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(i);
                res.add(sb.toString());
            }
        }
        return res;
    }
}
