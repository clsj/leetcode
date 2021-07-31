package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 有两个元素
        if (head.next.next == null) return head.next.val == head.val;

        // 找到中间节点
        ListNode midNode = middleNode(head);

        // 从midNode 下一个开始反转链表
        ListNode rHead = reverseNode(midNode.next);

        while (rHead != null && head != null) {
            if (rHead.val != head.val) {
                return false;
            }
            rHead = rHead.next;
            head = head.next;
        }

        return true;
    }

    // 反转链表
    private ListNode reverseNode(ListNode node) {
        ListNode newHead = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }

    // 根据快慢指针 求出middle节点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);

        l11.next = l12;
//
//        ListNode l13 = new ListNode(3);
//
//        l12.next = l13;
//
//        ListNode l14 = new ListNode(4);
//        l13.next = l14;
//        ListNode l15 = new ListNode(5);
//        l14.next = l15;

        ListNode.printNode(l11);

//        ListNode listNode = new _234_回文链表().reverseNode(l11);

//        ListNode.printNode(listNode);


        ListNode middleNode = new _234_回文链表().middleNode(l11);

        System.out.println(middleNode.val);


//        new _234_回文链表().isPalindrome(l11);
    }

}
