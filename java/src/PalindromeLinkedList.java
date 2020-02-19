import java.util.Stack;

public class PalindromeLinkedList {
    // 链表
    //  检测回文有很多方法：
    //  1. 前半段入栈，和后半段对比。空间复杂度O(n)
    //  2. 前半段Reverse，和后半段对比 『走一半：fast指针』
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head, leftHead = null, tmp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; //这里一定要放前面

            // 这里进行反转，把slow放在首部
            tmp = slow.next;
            slow.next = leftHead;
            leftHead = slow;
            slow = tmp;


        }
        ListNode rightHead = fast == null ? slow : slow.next;

        while (rightHead != null && leftHead!=null) {
            if (rightHead.val != leftHead.val) return false;
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数 [1,2,1]-> fast.next==null -> stack[1] 后半段[2,1],slow在后半段
        // 偶数 [1,1]-> fast==null -> stack[1] 后半段[1], slow在后半段

        ListNode mid = fast == null ? slow : slow.next;
        while (mid != null) {
            if (mid.val != stack.pop()) return false;
            mid = mid.next;
        }
        return true;
    }
}
