/**
 * LeetCode problem # 187, 'Repeated DNA Sequences'
 * https://leetcode.com/problems/repeated-dna-sequences/
 */

/**
 * @param {string} s
 * @return {string[]}
 */
const findRepeatedDnaSequences = function (s) {
  const sequences = {};

  for (let i = 10; i <= s.length; ++i) {
    const curr = s.substring(i - 10, i);
    sequences[curr] = (sequences[curr] ?? 0) + 1;
  }
  return Object.keys(sequences).filter((key) => sequences[key] > 1);
};
