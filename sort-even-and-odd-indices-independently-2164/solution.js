/**
 * LeetCode problem # 2164, 'Sort Even and Odd Indices Independently'
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function sortEvenOdd(nums) {
  const oddInd = nums.filter((elem, i) => i % 2 !== 0);
  const evenInd = nums.filter((elem, i) => i % 2 === 0);

  oddInd.sort((a, b) => b - a);
  evenInd.sort((a, b) => a - b);

  let odd = 0;
  let even = 0;
  for (let i = 0; i < nums.length; ++i) {
    if (i % 2 === 0) {
      nums[i] = evenInd[even];
      ++even;
    } else {
      nums[i] = oddInd[odd];
      ++odd;
    }
  }
  return nums;
}
