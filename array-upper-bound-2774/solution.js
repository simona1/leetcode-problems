/**
 * LeetCode problem # 2774, 'Array Upper Bound'
 * https://leetcode.com/problems/array-upper-bound
 */

/**
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function (target) {
  let lo = 0;
  let hi = this.length;
  while (lo + 1 != hi) {
    const mid = (lo + hi) >> 1;
    if (this[mid] <= target) {
      lo = mid;
    } else {
      hi = mid;
    }
  }
  // console.log(lo, hi)
  return lo >= 0 && this[lo] === target ? lo : -1;
};

// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5
