/**
 * LeetCode problem # 2798, 'Number of Employees Who Met the Target'
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/
 */

/**
 * @param {number[]} hours
 * @param {number} target
 * @return {number}
 */

function numberOfEmployeesWhoMetTarget1(hours, target) {
  let res = 0;
  for (const hour of hours) {
    res += hour >= target ? 1 : 0;
  }
  return res;
}

function numberOfEmployeesWhoMetTarget2(hours, target) {
  return hours.filter((hour) => hour >= target).length;
}

function numberOfEmployeesWhoMetTarget(hours, target) {
  return hours.reduce((count, hour) => {
    return hour >= target ? count + 1 : count;
  }, 0);
}
