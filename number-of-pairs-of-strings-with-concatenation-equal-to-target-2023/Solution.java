/**
 * LeetCode problem # 2023, 'Number of Pairs of Strings With Concatenation Equal to Target'
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */

import java.util.*;

class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<Integer, Integer> prefixMap = new HashMap<>(); 
        Map<Integer, Integer> suffixMap = new HashMap<>();
	    int res = 0; 
        int n = target.length();

	    for (String num: nums) {
		    if (num.length() < n) {
                int m = num.length();

                boolean isPrefix = target.indexOf(num) == 0; 
                boolean isSufix = target.lastIndexOf(num)== n - m;

                if (isPrefix) {
                    res += suffixMap.getOrDefault(m, 0);
                }
                if (isSufix) {
                    res += prefixMap.getOrDefault(target.length() - m - 1, 0);
                }
                
                if(isPrefix) {
                    prefixMap.put(m - 1, prefixMap.getOrDefault(m - 1, 0) + 1);
                }
                if(isSufix) {
                    suffixMap.put(n - m, suffixMap.getOrDefault(n - m, 0) + 1);
                }
		    }
        }
	    return res;
    }
}
