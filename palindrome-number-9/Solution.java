
/**
 * LeetCode problem # 9, 'Palindrome Number'
 * https://leetcode.com/problems/palindrome-number/
 */

import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverseNum(x) == x;
    }

    private int reverseNum(int x) {
        int rev = 0;
        int num = x;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

}