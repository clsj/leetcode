package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class _239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int w = i - k + 1;
        while (i < nums.length) {
            Integer last = deque.peekLast();
            while (last != null && nums[i] >= nums[last]) {
                // 如果插入的值 大于队列的尾端 就删除队列的尾端
                deque.pollLast();
                last = deque.peekLast();
            }
            deque.offerLast(i);
            Integer first = deque.peekFirst();
            if (w > first) {
                deque.pollFirst();
                first = deque.peekFirst();
            }
            if (w >= 0) {
                result[w] = nums[first];
            }
            i++;
            w++;
        }

        return result;
    }


    public static void main(String[] args) {

        //    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//    输出：[3,3,5,5,6,7]

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;


//        int[] nums = new int[]{9,11};
//        int k = 2;

        _239_滑动窗口最大值 v = new _239_滑动窗口最大值();
        int[] result = v.maxSlidingWindow(nums, k);
        for (int r : result) {
            System.out.println(r);
        }

    }


}
