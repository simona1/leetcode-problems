/**
 * LeetCode problem # 1385, 'Find the Distance Value Between Two Arrays'
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays
 */

/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @param {number} d
 * @return {number}
 */
function findTheDistanceValue(arr1, arr2, d) {
  arr2.sort((a, b) => a - b);
  let res = 0;

  for (let i = 0; i < arr1.length; ++i) {
    let lo = -1;
    let hi = arr2.length;

    let a = 1;

    while (lo + 1 != hi) {
      let mid = lo + ((hi - lo) >> 1);
      if (Math.abs(arr2[mid] - arr1[i]) <= d) {
        a = 0;
        break;
      }
      if (arr2[mid] > arr1[i]) {
        hi = mid;
      } else {
        lo = mid;
      }
    }
    res += a;
  }
  return res;
}
