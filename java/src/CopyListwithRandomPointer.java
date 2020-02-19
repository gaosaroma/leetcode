import java.util.HashMap;

public class CopyListwithRandomPointer {
    // 链表
    // 仅遍历一次即复制List
    // 说明在深度复制之前，next节点与random节点要复制好，放在容器里->快速取->用HashMap
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>(); // 可以再复习一下泛型
        Node preHead = new Node(-1), cur = preHead;

        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }
            cur.next = map.get(head);

            if(head.random!=null){
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                cur.next.random = map.get((head.random));
            }

            head = head.next;
            cur = cur.next;
        }
        return preHead.next;
    }


}
