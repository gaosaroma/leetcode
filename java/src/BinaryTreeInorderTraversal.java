import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return _inorder(root, res);
    }

    public List<Integer> _inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return res;
        }

        _inorder(node.left, res);

        res.add(node.val);

        _inorder(node.right, res);

        return res;
    }

    public List<Integer> _inorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) { // 结束条件：没有node要入栈，而且栈为空
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            if (!s.isEmpty()) {
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }

        }
        return res;
    }

    public static void main(String[] args) {

    }
}