public class LinkedListCycleII {
    // 链表
    // k+n 与 k+2n -> 1步长指针和2步长指针 -> 第一次meet：当走了n与2n步，走到第-k个和第-k个->循环
    // 需要再走k步 -> 再来新指针从头开始
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //      再走k步
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}
