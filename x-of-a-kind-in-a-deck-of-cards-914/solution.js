/**
 * LeetCode problem # 914, 'X of a Kind in a Deck of Cards'
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

/**
 * @param {number[]} deck
 * @return {boolean}
 */
function hasGroupsSizeX(deck) {
  const freq = {};

  for (card of deck) {
    freq[card] = (freq[card] ?? 0) + 1;
  }
  const values = Object.values(freq);

  const lcd = (a, b) => {
    while (b !== 0) {
      const div = a % b;
      a = b;
      b = div;
    }
    return a;
  };
  return values.reduce((acc, val) => lcd(acc, val), values[0]) >= 2;
}
