package 排序数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0,0,0};
        new _75_颜色分类().sortColors(nums);
        for (int n :
                nums) {
            System.out.print(n + "->");
        }
    }

    // 三指针
    public void sortColors(int[] nums) {
        int index0 = 0;
        int index2 = nums.length -1;
        int cur = index0;

        while (index2 >= cur) {

            if (nums[cur] == 1) {
                cur++;
                continue;
            }

            if (nums[cur] == 0) {
                // 交换 index0 和cur的值
                swap(nums, index0, cur);
                index0++;
                cur++;
                continue;
            }

            if (nums[cur] == 2) {
                // 交换 index2 和cur的值
                swap(nums, index2, cur);
                index2--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
