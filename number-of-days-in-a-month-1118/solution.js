/**
 * LeetCode problem # 1118, 'Number of Days in a Month'
 * https://leetcode.com/problems/number-of-days-in-a-month
 */

/**
 * @param {number} year
 * @param {number} month
 * @return {number}
 */

// Leap year - year % 4 === 0 and (year % 100 !== 0 or year % 400 === 0)

function numberOfDays(year, month) {
  const mo = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29];

  const isLeapYear = (year) => {
    return year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0);
  };

  if (month === 2 && isLeapYear(year)) {
    return mo[12];
  }
  return mo[month - 1];
}
