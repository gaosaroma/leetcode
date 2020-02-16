public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 问题在于不知道root和pre都要保存下来  和   什么时候给root和pre赋值..

        if (l1 == null || l2 == null) return null;


        int carry = 0;
        ListNode root = null;
        ListNode pre = null;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);

            if (root == null) {
                root = tmp;
            } else {
                pre.next = tmp;
            }

            pre = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;

            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);

            pre.next = node;
            pre = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;

            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);

            pre.next = node;
            pre = node;
            l2 = l2.next;
        }


        if (carry != 0) {
            ListNode carryNode = new ListNode(carry);
            pre.next = carryNode;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
