public class RemoveNthFromEnd {
    // 链表
    // 双指针，fast比slow快n个
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null) {

            if (count > n) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }

        // 注意边界条件，当count==n而fast==null时，说明slow没有移动，但要删第一个
        if (count == n) {
            head = head.next;
        }

        // 当count>n而fast==null时，双指针挪fast和slow
        if (count > n) {
            ListNode deleteNode = slow.next;
            slow.next = deleteNode.next;
        }
        // 当count<n时，说明要删0以前的
        return head;
    }
}
