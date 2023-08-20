/**
 * LeetCode problem # 2828, 'Check if a String Is an Acronym of Words'
 * https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 */

/**
 * @param {string[]} words
 * @param {string} s
 * @return {boolean}
 */
const isAcronym = function (words, s) {
  return words.map((word) => word[0]).join("") === s;
};
