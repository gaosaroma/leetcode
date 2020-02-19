public class ReverseLinkedList {
    // 链表
    // 翻转，把head一直放在首部
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reHead = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = reHead;
            reHead = head;
            head = tmp;
        }
        return reHead;
    }
}
