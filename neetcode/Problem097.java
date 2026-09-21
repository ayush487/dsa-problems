//Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem097 {
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
    }

    private static class TreeNodeLevels {
        int level;
        TreeNode node;

        TreeNodeLevels(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> levelOrderList = levelOrder(root);
        for (List<Integer> level : levelOrderList) {
            list.add(level.getLast());
        }
        return list;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNodeLevels> queue = new LinkedList<>();
        if (root != null) queue.offer(new TreeNodeLevels(0, root));
        while (!queue.isEmpty()) {
            TreeNodeLevels lNode = queue.poll();
            int alSize = list.size();
            if (alSize == lNode.level) {
                list.add(new ArrayList<>());
            }
            list.get(lNode.level).add(lNode.node.val);
            if (lNode.node.left != null)
                queue.offer(new TreeNodeLevels(lNode.level + 1, lNode.node.left));
            if (lNode.node.right != null)
                queue.offer(new TreeNodeLevels(lNode.level + 1, lNode.node.right));
        }
        return list;
    }
}
