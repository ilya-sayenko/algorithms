package dfs;

import java.util.ArrayList;
import java.util.List;

public class DfsRecursive {

    public static List<TreeNode> dfs(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private static void helper(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            result.add(root);
            helper(root.getLeft(), result);
            helper(root.getRight(), result);
        }
    }
}
