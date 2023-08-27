/**
 * LeetCode problem # 2520, 'Count the Digits That Divide a Number'
 * https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 */
/**
 * @param {number} num
 * @return {number}
 */
function countDigits(num) {
  let res = 0;
  const digits = getDigits(num);
  for (const digit of digits) {
    if (num % digit === 0) {
      ++res;
    }
  }
  return res;
}

function getDigits(num) {
  return (num + "").split("").map((d) => parseInt(d));
}
