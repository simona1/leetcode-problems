/**
 * LeetCode problem # 1, 'Two Sum'
 * https://leetcode.com/problems/two-sum
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
function twoSum(nums, target) {
  const numsMap = {};

  nums.forEach((elem, index) => {
    numsMap[elem] = index;
  });

  for (let i = 0; i < nums.length; ++i) {
    const compl = target - nums[i];
    if (numsMap[compl] && numsMap[compl] !== i) {
      return [i, numsMap[compl]];
    }
  }
  return null;
}
