import java.util.ArrayList;
import java.util.List;

// 动态规划找规律的技巧是：【找规律】
// a. 看第n个与第n-1个的关系
// b. 看第n个与第i个的关系...
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
//        return _bruteForceRecursive(1, n);
        return _dynamicPlanning(n);
    }

    // 分治法，n可以由左子树的类别和右子树的类别得到；暴力递归
    private List<TreeNode> _bruteForceRecursive(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        // 递归结束条件： 左/右子树：要么是null，要么是一个节点（根节点）
        if (l > r) {
            res.add(null);
            return res;
        }

        if (l == r) {
            res.add(new TreeNode(l));
            return res;
        }

        for (int i = l; i < r + 1; i++) {
            List<TreeNode> leftSubTrees = _bruteForceRecursive(l, i - 1);
            List<TreeNode> rightSubTrees = _bruteForceRecursive(i + 1, r);

            for (TreeNode leftSub : leftSubTrees) {
                for (TreeNode rightSub : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSub;
                    root.right = rightSub;
                    res.add(root); // 根节点
                }
            }
        }

        return res;
    }

    // 动态规划，第n个由第n-1个决定 -> 新加入的数字因为最大，所以只会放在树的根节点或者右孩子里。
    private List<TreeNode> _dynamicPlanning(int n) {
        List<TreeNode> preList = new ArrayList<>();
        preList.add(new TreeNode(1));
        for (int i = 2; i < n + 1; i++) {
            List<TreeNode> curList = new ArrayList<>();
            for (TreeNode preRoot : preList) {
                // 放在根节点
                TreeNode curRoot = new TreeNode(i);
                curRoot.left = preRoot;
                curList.add(curRoot);

                // 放在所有的右孩子里
                TreeNode tmp = preRoot;
                int level = 0;
                while (tmp != null) {
                    TreeNode clonedRoot = _cloneTree(preRoot); // 要记得java的是浅拷贝
                    level += 1;
                    TreeNode newPos = clonedRoot;
                    for (int j = 0; j < level - 1; j++) {
                        newPos = newPos.right;
                    }

                    TreeNode insertNode = new TreeNode(i);
                    insertNode.left = newPos.right;
                    newPos.right = insertNode;
                    curList.add(clonedRoot);
                    tmp = tmp.right;
                }
            }
            preList = curList;
        }

        return preList;
    }

    private TreeNode _cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode cloned = new TreeNode(root.val);
        cloned.left = _cloneTree(root.left);
        cloned.right = _cloneTree(root.right);

        return cloned;
    }
}
