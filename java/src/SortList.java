public class SortList {
//    快排、堆排、归并排序的时间复杂度都是nlogn
//    快排有两种方式：1. l++与r--；2. p与q.next，这里可以用第二种 https://yq.aliyun.com/articles/71334
//    堆排是二叉树，也更适合数组
//    最适合链表的是归并
//    分治法

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        left = MergeList(left, right);

        return left;
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // 奇数 [a,b][c] slow=b ;偶数 [a,b] [c,d] slow=b
    }

    public ListNode MergeList(ListNode l, ListNode r) {
        ListNode pre = new ListNode(-1), cur = pre;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        ListNode rest = l == null ? r : l;

        cur.next = rest;
        return pre.next;
    }

    public static void main(String[] args) {

    }
}
