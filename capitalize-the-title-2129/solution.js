/**
 * LeetCode problem # 2129, 'Capitalize the Title'
 * https://leetcode.com/problems/capitalize-the-title
 */

/**
 * @param {string} title
 * @return {string}
 */
function capitalizeTitle(title) {
  const words = title.split(" ");

  for (let i = 0; i < words.length; ++i) {
    let word = words[i];
    if (word.length <= 2) {
      words[i] = word.toLowerCase();
    } else {
      words[i] = word[0].toUpperCase() + word.substring(1).toLowerCase();
    }
  }
  return words.join(" ");
}
