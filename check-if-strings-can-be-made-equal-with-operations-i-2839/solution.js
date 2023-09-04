/**
 * LeetCode problem # 2839, 'Check if Strings Can be Made Equal With Operations I'
 * https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
 */

/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const canBeEqual = function (s1, s2) {
  s1 = s1.split("");
  s2 = s2.split("");
  const n = s1.length;

  for (let i = 0; i < n - 2; ++i) {
    if (s1[i] !== s2[i]) {
      if (s1[i] === s2[i + 2]) {
        let tmp = s1[i + 2];
        s1[i + 2] = s1[i];
        s1[i] = tmp;
      }
    }
  }
  return s1.join("") === s2.join("");
};
