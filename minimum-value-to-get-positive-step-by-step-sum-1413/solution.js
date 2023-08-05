/**
 * LeetCode problem # 1413, 'Minimum Value to Get Positive Step by Step Sum'
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function minStartValue(nums) {
  let res = 1;

  while (true) {
    let total = res;
    let isValid = true;

    for (const num of nums) {
      total += num;

      if (total < 1) {
        isValid = false;
        break;
      }
    }
    if (!isValid) {
      ++res;
    } else {
      return res;
    }
  }
}
