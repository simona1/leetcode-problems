
/**
 * LeetCode problem # 1570, 'Dot Product of Two Sparse Vectors'
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 */

class SparseVector {
    private int[] arr;

    SparseVector(int[] nums) {
        this.arr = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;

        for (int i = 0; i < this.arr.length; ++i) {
            res += this.arr[i] * vec.arr[i];
        }
        return res;

    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
