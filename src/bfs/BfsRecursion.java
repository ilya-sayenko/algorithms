package bfs;

import java.util.ArrayList;
import java.util.List;

public class BfsRecursion {

    public static List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        return inorder(root, result);
    }

    private static List<TreeNode> inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return list;
        }

        inorder(root.getLeft(), list);
        list.add(root);
        inorder(root.getRight(), list);

        return list;
    }

    public static List<TreeNode> preorder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        return preorder(root, result);
    }

    private static List<TreeNode> preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return list;
        }

        list.add(root);
        inorder(root.getLeft(), list);
        inorder(root.getRight(), list);

        return list;
    }

    public static List<TreeNode> postorder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        return postorder(root, result);
    }

    private static List<TreeNode> postorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return list;
        }

        inorder(root.getLeft(), list);
        inorder(root.getRight(), list);
        list.add(root);

        return list;
    }
}
