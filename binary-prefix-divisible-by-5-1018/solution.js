/**
 * LeetCode problem # 1018, 'Binary Prefix Divisible By 5'
 * https://leetcode.com/problems/binary-prefix-divisible-by-5
 */

/**
 * @param {number[]} nums
 * @return {boolean[]}
 */

const prefixesDivBy5 = (nums, acc = 0) =>
  nums.map((num) => !(acc = (acc * 2 + num) % 5));
