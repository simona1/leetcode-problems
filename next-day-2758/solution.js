/**
 * LeetCode problem # 2758, 'Next Day'
 * https://leetcode.com/problems/next-day/
 */

Date.prototype.nextDay = function () {
  const currentDate = new Date(this.valueOf());
  currentDate.setDate(currentDate.getDate() + 1);

  const year = currentDate.getFullYear();
  const month = (currentDate.getMonth() + 1).toString().padStart(2, "0");
  const day = currentDate.getDate().toString().padStart(2, "0");

  return year + "-" + month + "-" + day;
};

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */
