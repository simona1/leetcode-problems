
/**
 * LeetCode problem # 275, 'H-Index II' https://leetcode.com/problems/h-index-ii
 */

class Solution {
    public int hIndex(int[] cit) {
        if (cit.length == 0) {
            return 0;
        }
        if (cit.length == 1) {
            return cit[0] == 0 ? 0 : 1;
        }
        int len = cit.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (cit[mid] > len - mid) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (cit[high] > len - high) {
            return len;
        }
        if (cit[high] == len - high) {
            return len - high;
        }
        return len - high - 1;
    }
}
