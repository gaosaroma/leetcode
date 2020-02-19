public class IntersectionofTwoLinkedLists {
    // 链表，求交点
    // 要求O(1)的空间复杂度 -> 不存节点 -> 指针来做->使两个链表的长度一致
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        ListNode curL = lenA > lenB ? headA : headB;
        ListNode curS = lenA > lenB ? headB : headA;

        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            curL = curL.next;
        }

        while (curS != null) {
            if (curL == curS) return curL;
            curL = curL.next;
            curS = curS.next;
        }
        return null;
    }
}
