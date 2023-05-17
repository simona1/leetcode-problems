/**
 * LeetCode problem # 809, 'Expressive Words'
 * https://leetcode.com/problems/expressive-words
 */

/**
 * @param {string} s
 * @param {string[]} words
 * @return {number}
 */
function expressiveWords(s, words) {
  let ans = 0;

  function runLengthEncode(str) {
    const res = [];
    let i = 0;
    while (i < str.length) {
      const c = str[i];
      let count = 0;
      while (i < str.length && str[i] == c) {
        ++count;
        ++i;
      }
      res.push([c, count]);
    }
    return res;
  }

  function isStretchy(original, stretched) {
    while (original.length > 0 && stretched.length > 0) {
      const co = original.pop();
      const cs = stretched.pop();
      if (co[0] !== cs[0]) {
        return false;
      }
      const oCount = co[1];
      const sCount = cs[1];
      if (sCount > oCount && sCount < 3) {
        return false;
      }
      if (oCount > sCount) {
        return false;
      }
    }
    return original.length == 0 && stretched.length == 0;
  }

  for (const word of words) {
    if (isStretchy(runLengthEncode(word), runLengthEncode(s))) {
      ++ans;
    }
  }
  return ans;
}
