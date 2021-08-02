package 字符串;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/submissions/
 */
public class _572_另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 序列化两棵树，比较是否包含就行了
        return serializeNode(root).contains(serializeNode(subRoot));
    }

    private String serializeNode(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        serializeNode(node, sb);
        return sb.toString();
    }

    private void serializeNode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#!");
            return;
        }
        serializeNode(node.left, sb);
        serializeNode(node.right, sb);
        sb.append(node.val).append("!");
    }

}
