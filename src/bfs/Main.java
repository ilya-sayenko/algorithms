package bfs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
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

        List<TreeNode> resultIter = BfsIter.bfs(a);

        System.out.println("BFS iter:");
        resultIter.forEach(node -> System.out.print(node.getName() + "-->"));
    }
}
