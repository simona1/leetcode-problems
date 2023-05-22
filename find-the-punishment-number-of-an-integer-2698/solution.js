/**
 * LeetCode problem # 2698, 'Find the Punishment Number of an Integer'
 * https://leetcode.com/problems/find-the-punishment-number-of-an-integer
 */

/**
 * @param {number} n
 * @return {number}
 */
function punishmentNumber(n) {
  let res = 0;
  for (let i = 1; i <= n; i++) {
    const squared = i * i;
    const squaredString = squared.toString();

    if (canSplitStringToSum(squaredString, i)) {
      res += squared;
    }
  }
  return res;
}

function canSplitStringToSum(str, target) {
  function helper(str, target, start, currentSum) {
    if (start === str.length && currentSum === target) {
      return true;
    }

    for (let i = start; i < str.length; ++i) {
      const substr = str.substring(start, i + 1);
      const num = parseInt(substr, 10);

      if (num > target) {
        break;
      }

      if (helper(str, target, i + 1, currentSum + num)) {
        return true;
      }
    }
    return false;
  }
  return helper(str, target, 0, 0);
}
