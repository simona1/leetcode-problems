/**
 * LeetCode problem # 1431, 'Kids With the Greatest Number of Candies'
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 */

/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */

function* kidsWithCandiesGenerator(candies, extraCandies) {
  const maxNum = Math.max(...candies);
  for (const candy of candies) {
    yield candy + extraCandies >= maxNum;
  }
}

function kidsWithCandies(candies, extraCandies) {
  // return Array.from(
  //   kidsWithCandiesGenerator(candies, extraCandies),
  //   (value) => value
  // );
  return [...kidsWithCandiesGenerator(candies, extraCandies)];
}
