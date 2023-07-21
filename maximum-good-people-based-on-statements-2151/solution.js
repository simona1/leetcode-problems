/**
 * LeetCode problem # 2151, 'Maximum Good People Based on Statements'
 * https://leetcode.com/problems/maximum-good-people-based-on-statements/
 */

/**
 * @param {number[][]} statements
 * @return {number}
 */
function maximumGood(statements) {
  const n = statements.length;
  let max = 0;

  function generateAll(arr, index, count) {
    if (index == arr.length) {
      let res = check(arr);
      if (res) {
        max = Math.max(max, count);
      }
      return;
    }
    generateAll(arr, index + 1, count);
    arr[index] = 1;

    generateAll(arr, index + 1, count + 1);
    arr[index] = 0;
  }

  function check(arr) {
    for (let i = 0; i < n; ++i) {
      if (arr[i] == 0) {
        continue;
      }
      for (let j = 0; j < n; ++j) {
        if (statements[i][j] == 2) {
          continue;
        }
        if (
          (statements[i][j] == 1 && arr[j] == 0) ||
          (statements[i][j] == 0 && arr[j] == 1)
        ) {
          return false;
        }
      }
    }
    return true;
  }

  const arr = Array(n).fill(0);
  generateAll(arr, 0, 0);
  return max;
}
