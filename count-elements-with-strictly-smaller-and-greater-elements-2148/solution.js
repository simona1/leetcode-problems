/**
 * LeetCode problem # 2148, 'Count Elements With Strictly Smaller and Greater Elements'
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function countElements(nums) {
  nums.sort((a, b) => a - b);
  const map = {};

  for (const num of nums) {
    map[num] = (map[num] ?? 0) + 1;
  }

  let res = 0;
  for (const key of Object.keys(map)) {
    if (key > nums[0] && key < nums.at(-1)) {
      res += map[key];
    }
  }
  return res;
}
