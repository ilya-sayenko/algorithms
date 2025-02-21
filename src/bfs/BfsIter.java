package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BfsIter {

    public static List<TreeNode> bfs(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node);

            if (node.getLeft() != null) {
                stack.add(node.getLeft());
            }

            if (node.getRight() != null) {
                stack.add(node.getRight());
            }
        }

        return result;
    }
}
