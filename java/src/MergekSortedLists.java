public class MergekSortedLists {
    // 分治法
    // 适合merge的都可以这样做
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divideConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideConquer(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + (r - l) / 2;
        ListNode leftList = divideConquer(lists, l, mid);
        ListNode rightList = divideConquer(lists, mid + 1, r);
        return mergeList(leftList, rightList);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0), cur = pre;
        while (l1 != null & l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;

            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }

}
