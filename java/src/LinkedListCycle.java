public class LinkedListCycle {
    // 链表
    // 验证是否循环，空间复杂度O(1)->指针来做->双指针
    // k+n 与 k+2n -> 1步长指针和2步长指针 -> 第一次meet：当走了n与2n步，走到第-k个和第-k个->循环
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode cur1 = head.next, cur2 = head.next.next;
        while (cur1 != null && cur2 != null && cur1 != cur2) {

            if (cur2.next == null) return false;
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1 != null && cur2 != null ;
    }
}
