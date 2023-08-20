/**
 * LeetCode problem # 2815, 'Max Pair Sum in an Array'
 * https://leetcode.com/problems/max-pair-sum-in-an-array/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

/* brute force */
const maxSum1 = (nums) => {
  let n = nums.length;
  let res = -1;

  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      if (maxDigit(nums[i]) == maxDigit(nums[j])) {
        res = Math.max(res, nums[i] + nums[j]);
      }
    }
  }
  return res;
};

const maxDigit = (num) => {
  let digits = (num + "").split("").map(Number);
  return Math.max(...digits);
};

function maxSum(nums) {
  const cache = new Array(10).fill(-1);
  let res = -1;

  for (const num of nums) {
    let compl = 0;
    let numCopy = num;

    while (numCopy > 0) {
      compl = Math.max(compl, numCopy % 10);
      numCopy = Math.floor(numCopy / 10);
    }

    if (cache[compl] != -1) {
      res = Math.max(res, cache[compl] + num);
    }
    cache[compl] = Math.max(cache[compl], num);
  }
  return res;
}
