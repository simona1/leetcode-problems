/*
 * LeetCode problem # 912, 'Sort an Array'
 * https://leetcode.com/problems/sort-an-array/
 */

class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start] };
        }

        int mid = start + (end - start) / 2;
        int[] leftHalf = mergeSort(nums, start, mid);
        int[] rightHalf = mergeSort(nums, mid + 1, end);

        return mergeHalves(leftHalf, rightHalf);
    }

    private int[] mergeHalves(int[] left, int[] right) {
        int n = left.length;
        int m = right.length;
        int[] res = new int[n + m];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (leftIndex < n && rightIndex < m) {
            if (left[leftIndex] <= right[rightIndex]) {
                res[index++] = left[leftIndex++];
            } else {
                res[index++] = right[rightIndex++];
            }
        }

        if (leftIndex < n) {
            for (int i = index; i < res.length; ++i) {
                res[i] = left[leftIndex++];
            }
        } else {
            for (int i = index; i < res.length; ++i) {
                res[i] = right[rightIndex++];
            }
        }
        return res;
    }
}
