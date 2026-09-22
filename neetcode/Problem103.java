//Serialize and Deserialize Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class Problem103 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    public String serialize(TreeNode root) {
        if (root == null) return "N";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("N,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[idx].equals("N")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[idx]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            idx++;
            if (!nodes[idx].equals("N")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[idx]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            idx++;
        }
        return root;
    }

}
