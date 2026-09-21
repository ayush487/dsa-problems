//Valid Binary Search Tree

public class Problem100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isInRange(root, false, 0, false, 0);
    }

    private boolean isInRange(TreeNode node, boolean startLimit, int start, boolean endLimit, int end) {
        if (node == null) return true;
        if ((startLimit && node.val <= start) || (endLimit && node.val >= end)) return false;
        return isInRange(node.left, startLimit, start, true, node.val) &&
                isInRange(node.right, true, node.val, endLimit, end);
    }
}
