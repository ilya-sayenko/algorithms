package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class DfsIter {

    public static List<TreeNode> dfs(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            result.add(node);

            if (node.getRight() != null) {
                queue.push(node.getRight());
            }

            if (node.getLeft() != null) {
                queue.push(node.getLeft());
            }
        }

        return result;
    }

    public static List<TreeNode> dfs2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node);

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return result;
    }
}
