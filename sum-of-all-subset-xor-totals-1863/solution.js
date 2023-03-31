/**
 * LeetCode problem # 1863, 'Sum of All Subset XOR Totals'
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

const subsetXORSum = (nums) => {
  const compute = (i = 0, x = 0) => {
    if (i === nums.length) {
      return x;
    }
    const a = compute(i + 1, x ^ nums[i]);
    const b = compute(i + 1, x);
    return a + b;
  };
  return compute();
};
