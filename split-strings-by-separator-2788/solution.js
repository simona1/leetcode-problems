/**
 * LeetCode problem # 2788, 'Split Strings by Separator'
 * https://leetcode.com/problems/split-strings-by-separator
 */

/**
 * @param {string[]} words
 * @param {character} separator
 * @return {string[]}
 */
function splitWordsBySeparator(words, sep) {
  const res = [];
  for (const word of words) {
    for (elem of splitIntoWordsGenerator(word, sep)) {
      res.push(elem);
    }
  }
  return res;
}

function* splitIntoWordsGenerator(str, sep) {
  let curr = "";
  for (let i = 0; i < str.length; ++i) {
    if (str[i] !== sep) {
      curr += str[i];
    } else {
      if (curr.length) {
        yield curr;
        curr = "";
      }
    }
  }
  if (curr.length) {
    yield curr;
  }
}
