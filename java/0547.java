class UnionFind {
    public int[] roots, rank;

    public UnionFind(int numNodes) {
        roots = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            roots[i] = i;
        }
        rank = new int[numNodes];
    }

    public int find(int x) {
        if (roots[x] != x) {
            roots[x] = find(roots[x]);
        }
        return roots[x];
    }

    public int union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) {
            return 0;
        } else if (rank[rootX] < rank[rootY]) {
            roots[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            roots[rootY] = rootX;
        } else {
            roots[rootY] = rootX;
            rank[rootX]++;
        }
        return 1;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int numProvinces = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    numProvinces -= uf.union(i, j);
                }
            }
        }

        return numProvinces;
    }
}