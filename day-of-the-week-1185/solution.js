/**
 * LeetCode problem # 1185, 'Day of the Week'
 * https://leetcode.com/problems/day-of-the-week
 */

/**
 * @param {number} day
 * @param {number} month
 * @param {number} year
 * @return {string}
 */
function dayOfTheWeek(day, month, year) {
  const d = `${month}/${day}/${year}`;
  const date = new Date(d);

  const weekdays = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];
  const weekdayIndex = date.getDay();

  return weekdays[weekdayIndex];
}
