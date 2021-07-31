package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            // 防止重复死循环
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
