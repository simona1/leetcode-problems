/**
 * LeetCode problem # 2215, 'Find the Difference of Two Arrays'
 * https://leetcode.com/problems/find-the-difference-of-two-arrays
 */

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
function findDifference(nums1, nums2) {
  const uniq1 = new Set();
  const uniq2 = new Set();

  for (const num of nums1) {
    uniq1.add(num);
  }

  for (const num of nums2) {
    uniq2.add(num);
  }

  const res1 = [];
  const res2 = [];

  for (const num of uniq1) {
    if (!uniq2.has(num)) {
      res1.push(num);
    }
  }

  for (const num of uniq2) {
    if (!uniq1.has(num)) {
      res2.push(num);
    }
  }
  return [res1, res2];
}
