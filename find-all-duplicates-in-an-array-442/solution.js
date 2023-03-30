/**
 * LeetCode problem # 442, 'Find All Duplicates in an Array'
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function findDuplicates(nums) {
  const freq = {};

  for (const num of nums) {
    freq[num] = (freq[num] ?? 0) + 1;
  }

  return Object.keys(freq).filter((elem) => freq[elem] === 2);
}
