package challenges.hard.medianOfTwoSortedArrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums1 = { 2 }, nums2 = { 2 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // Runtime: 2 ms, faster than 99.69% of Java online submissions for Median of
    // Two Sorted Arrays.
    // Memory Usage: 39.9 MB, less than 91.64% of Java online submissions for Median
    // of Two Sorted Arrays.
    // Consistently faster, similar memory usage
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int val1 = 0, val2 = 0, index1 = 0, index2 = 0, len = nums1.length + nums2.length;
        while (index1 + index2 <= (len / 2)) {
            val1 = val2;
            if (index1 == nums1.length) {
                val2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                val2 = nums1[index1];
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                val2 = nums2[index2];
                index2++;
            } else {
                val2 = nums1[index1];
                index1++;
            }
        }
        return (len % 2 != 0) ? (double) val2 : (double) (val1 + val2) / 2;
    }
}
