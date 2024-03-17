class UnionFind {
    int[] root, rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x != root[x]) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public int union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            return 1;
        }
        return 0;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            n -= uf.union(edge[0], edge[1]);
        }
        return n;
    }
}