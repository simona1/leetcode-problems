/**
 * LeetCode problem # 2848, 'Points That Intersect With Cars'
 * https://leetcode.com/problems/points-that-intersect-with-cars
 */

/**
 * @param {number[][]} nums
 * @return {number}
 */
const numberOfPoints = function (nums) {
  nums.sort((a, b) => a[0] - b[0]);

  const set = new Set();
  for (const num of nums) {
    let start = num[0];
    const end = num[1];
    while (start <= end) {
      set.add(start);
      ++start;
    }
  }
  return set.size;
};
