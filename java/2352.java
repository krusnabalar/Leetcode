class Solution {
    int[][] grid;

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int pairs = 0;
        this.grid = grid;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                if (grid[r][0] == grid[0][c])
                    pairs += checkRowColumnMatch(r, c) ? 1 : 0;

        return pairs;
    }

    private boolean checkRowColumnMatch(int r, int c) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[r][i] != grid[i][c])
                return false;
        }
        return true;
    }
}