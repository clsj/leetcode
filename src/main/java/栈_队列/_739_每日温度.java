package 栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_每日温度 {

    // 方法2 动态规划
    // 1. 从最后的下标-1开始 i, j = i+ 1
    // 2. 如果nums[i] < nums[j] 直接可以得出答案
    // 3. 否则 j 可以通过求出来的值 找到第一个比j下标大的值 和i比较 重复上边的操作



    // 相当于求出右点第一个比它大的
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty()) {
                Integer peek = stack.peek();
                if (temperatures[i] > temperatures[peek]) {
                    Integer pop = stack.pop();
                    result[pop] = i - pop;
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
