/**
 * LeetCode problem # 278, 'First Bad Version'
 * https://leetcode.com/problems/first-bad-version
 */

/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean
 * isBadVersion(int version);
 */
class VersionControl {
    static boolean isBad;

    public static boolean isBadVersion(int version) {
        return isBad;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            boolean curr = isBadVersion(mid);
            if (curr) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}