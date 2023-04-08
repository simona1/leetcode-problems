/**
 * LeetCode problem # 760, 'Find Anagram Mappings'
 * https://leetcode.com/problems/find-anagram-mappings
 */

/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
function anagramMappings(A, B) {
  const indexes = [];
  const m = {};
  for (let i = 0; i < B.length; ++i) {
    m[B[i]] = i;
  }
  for (let i = 0; i < A.length; ++i) {
    indexes.push(m[A[i]]);
  }
  return indexes;
}
