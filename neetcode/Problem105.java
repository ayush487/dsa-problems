//Delete Leaves With a Given Value

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Map<TreeNode, TreeNode> parents;
    private Map<TreeNode, Boolean> parentChildSide;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        parents = new HashMap<>();
        parentChildSide = new HashMap<>();
        fillChildren(root, root.left, true);
        fillChildren(root, root.right, false);
        boolean left = deleteChildNodeIfRequired(root.left, target);
        boolean right = deleteChildNodeIfRequired(root.right, target);
        if (left && right && root.val == target) return null;
        return root;
    }

    private boolean deleteChildNodeIfRequired(TreeNode root, int target) {
        if (root == null) return true;
        boolean left = deleteChildNodeIfRequired(root.left, target);
        boolean right = deleteChildNodeIfRequired(root.right, target);
        if (left && right) {
            if (root.val != target) return false;
            boolean isLeftChild = parentChildSide.get(root);
            if (isLeftChild) parents.get(root).left = null;
            else parents.get(root).right = null;
            return true;
        }
        return false;
    }

    private void fillChildren(TreeNode parent, TreeNode child, boolean isLeft) {
        if (child == null) return;
        parents.put(child, parent);
        parentChildSide.put(child, isLeft);
        fillChildren(child, child.left, true);
        fillChildren(child, child.right, false);
    }
}
