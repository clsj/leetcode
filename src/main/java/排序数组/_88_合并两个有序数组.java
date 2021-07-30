package 排序数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};

        new _88_合并两个有序数组().merge(nums1, 3, nums2, 3);

        for (int n :
                nums1) {
            System.out.print(n + "->");
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left1 = m -1;
        int right1 = m + n - 1;

        int left2 = n -1;

        while (left2 >= 0) {

            if (left1 >= 0 && nums1[left1] > nums2[left2]) {
                nums1[right1--] = nums1[left1--];
            }else {
                nums1[right1--] = nums2[left2--];
            }
        }
    }

    public void merge02(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        int left1 = m -1;
        int right1 = m + n - 1;

        int left2 = n -1;

        while (left1 >= 0 && left2 >= 0) {
            if (nums1[left1] <= nums2[left2]) {
                nums1[right1--] = nums2[left2--];
            }else if (nums1[left1] > nums2[left2]) {
                nums1[right1--] = nums1[left1--];
            }
        }

        while (left2 >= 0) {
            nums1[right1--] = nums2[left2--];
        }
    }
}
