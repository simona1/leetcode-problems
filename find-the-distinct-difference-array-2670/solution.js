/**
 * LeetCode problem # 2670, 'Find the Distinct Difference Array'
 * https://leetcode.com/problems/find-the-distinct-difference-array
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function distinctDifferenceArray(nums) {
  const res = nums.map((num, i) => {
    const pref = new Set(nums.slice(0, i + 1));
    const suff = new Set(nums.slice(i + 1));
    return pref.size - suff.size;
  });
  return res;
}
