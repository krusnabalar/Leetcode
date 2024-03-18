import java.util.*;

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
            x = find(root[x]);
        }
        return x;
    }

    public void union(int x, int y) {
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
        }
    }
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        Map<Integer, List<Integer>> rootToIdx = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            rootToIdx.putIfAbsent(root, new ArrayList<>());
            rootToIdx.get(root).add(i);
        }

        char[] res = new char[n];
        for (List<Integer> indices : rootToIdx.values()) {
            List<Character> chars = new ArrayList<>();
            for (int index : indices) {
                chars.add(s.charAt(index));
            }
            Collections.sort(chars);

            for (int idx = 0; idx < indices.size(); idx++) {
                res[indices.get(idx)] = chars.get(idx);
            }
        }
        return new String(res);
    }
}