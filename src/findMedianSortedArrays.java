import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        System.out.println(STR.">>>> merged: \{i} \{j} \{Arrays.toString(merged)}");

        while (i < m) {
            merged[k++] = nums1[i++];
        }


        while (j < n) {
            merged[k++] = nums2[j++];
        }

        if ((m + n) % 2 == 0) {
            return (merged[(m + n) / 2 - 1] + merged[(m + n) / 2]) / 2.0;
        } else {
            return merged[(m + n) / 2];
        }
    }
}

void main() {
    Solution solution = new Solution();

    int[] nums2 = {1, 3,3 ,4,5,6,7,8,9,10};
    int[] nums1 = {2, 23,34,45,56,78,89,100, 111};
    double result1 = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println("Median of nums1 and nums2: " + result1); // Expected output: 2.0

    int[] nums3 = {1, 2};
    int[] nums4 = {3, 4};
    double result2 = solution.findMedianSortedArrays(nums3, nums4);
    System.out.println("Median of nums3 and nums4: " + result2); // Expected output: 2.5
}

/* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
* Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
* */