/**
 * LeetCode problem # 1360, 'Number of Days Between Two Dates'
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int a = getDays(date1);
        int b = getDays(date2);
        return Math.abs(a - b);

    }

    int[] yearToDate = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    private int getDays(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int yearDiff = year - 1 - 1900;
        int dayDiff = yearDiff * 365 + yearDiff / 4; // leap

        int diffMonth = yearToDate[month - 1];

        // is leap
        if (isLeap(year) && month - 1 >= 2) {
            ++diffMonth;
        }
        return dayDiff + diffMonth + day;
    }

    private boolean isLeap(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
    }
}
