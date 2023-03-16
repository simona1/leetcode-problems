/**
 * LeetCode problem # 748, 'Shortest Completing Word'
 * https://leetcode.com/problems/shortest-completing-word
 */

/**
 * @param {string} licensePlate
 * @param {string[]} words
 * @return {string}
 */
var shortestCompletingWord = function (licensePlate, words) {
  const lcp = getFrequencyMapForChars(licensePlate.toLowerCase());

  let res = null;
  for (const word of words) {
    const fr = getFrequencyMapForChars(word);

    let isFound = true;
    for (const c of Object.keys(lcp)) {
      if ((fr[c] ?? 0) < lcp[c]) {
        isFound = false;
        break;
      }
    }
    if (!isFound) {
      continue;
    }
    if (res == null || res.length > word.length) {
      res = word;
    }
  }
  return res;
};

function getFrequencyMapForChars(word) {
  const freq = {};

  for (const c of word) {
    if (isCharacter(c)) {
      freq[c] = (freq[c] ?? 0) + 1;
    }
  }

  return freq;
}

function getFrequencyMap(word) {
  const freq = {};

  for (const c of word) {
    freq[c] = (freq[c] ?? 0) + 1;
  }
  return freq;
}

function getShortestWordByIndex(words) {
  let res = null;

  for (const word of words) {
    if (res == null || res.length > word.length) {
      res = word;
    }
  }
  return res;
}

function isCharacter(c) {
  return c >= "a" && c <= "z";
}
