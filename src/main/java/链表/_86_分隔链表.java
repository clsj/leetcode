package 链表;

import common.ListNode;

/**
 * 86. 分隔链表
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {

        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();

        ListNode node1 = head1;
        ListNode node2 = head2;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                node1.next = new ListNode(cur.val);
                node1 = node1.next;
            }else {
                node2.next = new ListNode(cur.val);
                node2 = node2.next;
            }
            cur = cur.next;
        }
        node1.next = head2.next;
        return head1.next;
    }
}
