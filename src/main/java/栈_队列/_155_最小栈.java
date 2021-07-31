package 栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */

public class _155_最小栈 {
//    class MinStack {
//        private final Stack<Integer> stack;
//        private final Stack<Integer> minStack;
//        public MinStack() {
//            stack = new Stack<>();
//            minStack = new Stack<>();
//        }
//
//        public void push(int val) {
//            stack.push(val);
//
//            if (minStack.empty()) {
//                minStack.push(val);
//            }else {
//                minStack.push(Math.min(val, minStack.peek()));
//            }
//        }
//
//        public void pop() {
//            stack.pop();
//            minStack.pop();
//        }
//
//        public int top() {
//            return stack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }

    class MinStack {
        private Node head;

        public MinStack() {
            head = new Node(0, Integer.MAX_VALUE, null);
        }
        //push(x) —— 将元素 x 推入栈中。
        public void push(int val) {
            head = new Node(val, Math.min(val, head.min), head);
        }

        //pop()—— 删除栈顶的元素。
        public void pop() {
            head = head.next;
        }

        //top()—— 获取栈顶元素。
        public int top() {
            return head.val;
        }

        //getMin() —— 检索栈中的最小元素。
        public int getMin() {
            return head.min;
        }

        private class Node{
            int val;
            int min;
            Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

}
