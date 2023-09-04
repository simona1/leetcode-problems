/**
 * LeetCode problem # 2843, 'Count Symmetric Integers'
 * https://leetcode.com/problems/count-symmetric-integers/
 */

function countSymmetricIntegers(low: number, high: number): number {
  let res = 0;
  for (let i = low; i <= high; ++i) {
    res += isSymmetricNumber(i) ? 1 : 0;
  }
  return res;
}

function countNumberOfDigits(num: number): number {
  return 1 + Math.floor(Math.log10(num));
}

function getNthDigit(num: number, n: number): number {
  return Math.floor(num / 10 ** n) % 10;
}

function isSymmetricNumber(num: number) {
  const numDigits = countNumberOfDigits(num);
  if (numDigits % 2 !== 0) {
    return false;
  }

  let i = 0;
  let j = numDigits - 1;
  let tally = 0;
  while (i < j) {
    tally += getNthDigit(num, i) - getNthDigit(num, j);
    ++i;
    --j;
  }
  return tally === 0;
}
