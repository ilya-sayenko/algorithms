package unionfind;

public class UnionFind {

    private final int[] parent;
    private final int[] rank;

    // 1. Initialize Union-Find structure with N items
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element is its own parent initially
            rank[i] = 0;   // Initial rank/depth of all trees is 0
        }
    }

    // 2. Find the representative (root) of the set containing element 'i'
    // Includes Path Compression optimization
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // сжимаем путь
        }
        return parent[x];
    }

    // 3. Merge the sets containing elements 'i' and 'j'
    // Includes Union by Rank optimization
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // If they already belong to the same set, do nothing
        if (rootI == rootJ) {
            return;
        }

        // Attach smaller rank tree under root of higher rank tree
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            // If ranks are same, make one as root and increment its rank
            parent[rootJ] = rootI;
            rank[rootI]++;
        }
    }

    // 4. Check if two elements belong to the same set
    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
