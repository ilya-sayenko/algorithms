package dfs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         *            A
         *         B     C
         *       D   E      F
         */
        TreeNode d = new TreeNode("D", null, null);
        TreeNode e = new TreeNode("E", null, null);
        TreeNode f = new TreeNode("F", null, null);
        TreeNode b = new TreeNode("B", d, e);
        TreeNode c = new TreeNode("C", null, f);
        TreeNode a = new TreeNode("A", b, c);

        List<TreeNode> resultRecursive = DfsRecursive.dfs(a);
        List<TreeNode> resultIter1 = DfsIter.dfs(a);
        List<TreeNode> resultIter2 = DfsIter.dfs2(a);

        System.out.println("DFS recursive:");
        resultRecursive.forEach(node -> System.out.print(node.getName() + "-->"));
        System.out.println();
        System.out.println("DFS iter1:");
        resultIter1.forEach(node -> System.out.print(node.getName() + "-->"));
        System.out.println();
        System.out.println("DFS iter2:");
        resultIter2.forEach(node -> System.out.print(node.getName() + "-->"));
    }
}
