/**
 * LeetCode problem # 2678, 'Number of Senior Citizens'
 * https://leetcode.com/problems/number-of-senior-citizens/
 */

/**
 * @param {string[]} details
 * @return {number}
 */
function countSeniors(details) {
  return details.filter((elem) => Number(elem.substring(11, 13)) > 60).length;
}
