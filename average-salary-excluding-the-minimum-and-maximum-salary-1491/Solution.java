
/**
 * LeetCode problem # 1491, 'Average Salary Excluding the Minimum and Maximum
 * Salary'
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 */

class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = 0;
        double total = 0.0;
        int n = salary.length - 2;
        for (int sal : salary) {
            minSalary = Math.min(minSalary, sal);
            maxSalary = Math.max(maxSalary, sal);
            total += sal;
        }

        int subtr = minSalary + maxSalary;
        total -= subtr;

        double result = total / n;
        return result;
    }
}