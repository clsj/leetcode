package 栈_队列;

import common.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _654_最大二叉树 {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,6,0,5};
        _654_最大二叉树 v = new _654_最大二叉树();
        v.constructMaximumBinaryTree(nums);
    }

    // 使用单调递减的栈
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int[] parentIndex = parentIndex(nums);
        for (int index :parentIndex) {
            System.out.print(index + " -> ");
        }

        return null;
    }

    // 可以求 左边右点 第一个最大值
    public int[] parentIndex(int[] nums) {
        int[] leftBigIndex = new int[nums.length];
        Arrays.fill(leftBigIndex, -1);
        int[] rightBigIndex = new int[nums.length];
        Arrays.fill(rightBigIndex, -1);
        // 存放下标
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty()) {
                Integer peek = stack.peek();
                if (nums[i] > nums[peek]) {
                    // 能pop出来的数据 说明pop的下标是右边第一个比它大的值
                    Integer pop = stack.pop();
                    rightBigIndex[pop] = i;
                }
                if (nums[i] < nums[peek]) {
                    leftBigIndex[i] = peek;
                    break;
                }
            }
            stack.push(i);
        }

        int[] parentIndex = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (leftBigIndex[i] == -1) {
                parentIndex[i] = rightBigIndex[i];
            }else if (rightBigIndex[i] == -1) {
                parentIndex[i] = leftBigIndex[i];
            }else {
                parentIndex[i] = nums[leftBigIndex[i]] < nums[rightBigIndex[i]] ? leftBigIndex[i] : rightBigIndex[i];
            }
        }

        return parentIndex;
    }

















    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return getRootNode(nums, 0, nums.length);
    }

    // 使用递归
    private TreeNode getRootNode(int[] nums, int begin, int end) {

        if (begin == end) {
            return null;
        }

        int maxIndex = begin;

        for (int i = begin + 1; i < end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode rootNode = new TreeNode(nums[maxIndex]);
        rootNode.left = getRootNode(nums, begin, maxIndex);
        rootNode.right = getRootNode(nums, maxIndex + 1, end);
        return rootNode;
    }

}
