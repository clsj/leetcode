package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        ListNode h = pre;
        pre.next = head;

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                if (next == null) {
                    pre.next = null;
                    cur = null;
                }else {
                    cur.val = next.val;
                    pre.next = next;
                    cur = next;
                }
            }else {
                pre = cur;
                cur = next;
            }
        }

        return h.next;
    }
}
