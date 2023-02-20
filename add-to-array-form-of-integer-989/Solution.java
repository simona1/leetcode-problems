/*
* LeetCode problem # 989, 'Add to Array-Form of Integer'
* https://leetcode.com/problems/add-to-array-form-of-integer/
* 
* The array-form of an integer num is an array representing its digits in left to 
* right order. For example, for num = 1321, the array form is [1,3,2,1].Given num, 
* the array-form of an integer, and an integer k, return the array-form of the integer num + k.
* 
*/

import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            int curr = num[i] + k;
            res.add(0, curr % 10);
            k = curr / 10;
        }
        while (k > 0) {
            res.add(0, k % 10);
            k /= 10;
        }
        return res;
    }
}
