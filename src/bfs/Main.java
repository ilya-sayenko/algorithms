package bfs;

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

        List<TreeNode> resultIter = BfsIter.bfs2(a);

        System.out.println("BFS iter:");
        resultIter.forEach(node -> System.out.print(node.getName() + "-->"));
        System.out.println();

        System.out.println("BFS recursion:");

        System.out.println("inorder:");
        List<TreeNode> inorder = BfsRecursion.inorder(a);
        inorder.forEach(node -> System.out.print(node.getName() + "-->"));
        System.out.println();

        System.out.println("preorder:");
        List<TreeNode> preorder = BfsRecursion.preorder(a);
        preorder.forEach(node -> System.out.print(node.getName() + "-->"));
        System.out.println();

        System.out.println("postorder:");
        List<TreeNode> postorder = BfsRecursion.postorder(a);
        postorder.forEach(node -> System.out.print(node.getName() + "-->"));
    }
}
