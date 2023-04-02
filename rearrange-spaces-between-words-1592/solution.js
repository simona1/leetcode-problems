/**
 * LeetCode problem # 1592, 'Rearrange Spaces Between Words'
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */

/**
 * @param {string} text
 * @return {string}
 */
function reorderSpaces(text) {
  let spaceCount = 0;
  const words = text.split(" ").filter((el) => el !== "");

  for (const c of text) {
    if (c === " ") {
      ++spaceCount;
    }
  }

  const spaces = Math.floor(spaceCount / (words.length - 1));
  const rem = spaceCount - spaces * (words.length - 1);

  if (words.length > 1) {
    return words.join(" ".repeat(spaces)) + " ".repeat(rem);
  }
  return words.join("") + " ".repeat(spaceCount);
}
