/**
 * LeetCode problem # 434, 'Number of Segments in a String'
 * https://leetcode.com/problems/number-of-segments-in-a-string
 */

/**
 * @param {string} s
 * @return {number}
 */
const countSegments = function (s) {
  const matches = s.match(/\S+/g);
  return matches?.length ?? 0;
};

/*
Match sequences of non-whitespace characters with `\S+`
The uppercase S is "not a space".
`g` flag at the end means search globally, i.e. match all occurrencs not just the first one
matches will be an array so we return its length if not nullish

*/
