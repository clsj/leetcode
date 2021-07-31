package 链表;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加 {

    public static void main(String[] args) {
//        2,4,3
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);

        l11.next = l12;

        ListNode l13 = new ListNode(9);

        l12.next = l13;

        ListNode l14 = new ListNode();
        ListNode l15 = new ListNode();

//        5,6,4
        ListNode l21 = new ListNode(9);

        ListNode l22 = new ListNode(6);
//        l21.next = l22;
        ListNode l23 = new ListNode(4);

//        l22.next = l23;

        ListNode l24 = new ListNode();
        ListNode l25 = new ListNode();

        _2_两数相加 v = new _2_两数相加();
        v.addTwoNumbers(l11, l21);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;
        int tens = 0;

        while (true) {

            int total = node1.val + node2.val + tens;
            // 个位
            int digits = total % 10;

            // 十位
            tens = total / 10;
            node1.val = digits;
            node2.val = digits;

            if (node1.next == null && node2.next == null) {
                // 两个都为空
                if (tens > 0) {
                    node1.next = new ListNode(tens);
                }
                break;
            }else {
                if (node1.next == null) {
                    node1.next = new ListNode(0);
                }
                if (node2.next == null) {
                    node2.next = new ListNode(0);
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }

        return l1;
    }
}
