package 排序数组;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 */
public class _面试题_16_16_部分排序 {

    public static void main(String[] args) {
//        int[] array = new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] array = new int[] {1,2,4,7,16,18,19};

        int[] sort = new _面试题_16_16_部分排序().subSort(array);
        for (int s :
                sort) {
            System.out.println(s);
        }
    }

    public int[] subSort(int[] array) {
        int[] result = new int[] {-1, -1};

        // 从左往右找到最后一个逆序对的下标 为result[1]的值
        int flag = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (flag > array[i]) {
                result[1] = i;
            }else {
                flag = array[i];
            }
        }

        //
        if (result[1] == -1) {
            return result;
        }

        flag = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (flag < array[i]) {
                result[0] = i;
            }else {
                flag = array[i];
            }
        }

        return result;
    }
}
