/**
 * LeetCode problem # 648, 'Replace Words'
 * https://leetcode.com/problems/replace-words
 */

function replaceWords1(dictionary, sentence) {
  return sentence
    .split(" ")
    .map((word) => findRootWord(word, dictionary))
    .join(" ");
}

function findRootWord(word, dictionary) {
  let res = word;
  for (const potentialRoot of dictionary) {
    if (!word.startsWith(potentialRoot)) {
      continue;
    }
    if (potentialRoot.length < res.length) {
      res = potentialRoot;
    }
  }
  return res;
}
