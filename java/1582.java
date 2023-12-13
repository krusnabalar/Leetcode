class Solution {
    public int numSpecial(int[][] mat) {
        int specials = 0;
        int[] onesInCols = new int[mat[0].length];
        int[] onesInRows = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    onesInRows[i]++;
                    onesInCols[j]++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (onesInRows[i] == 1) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (onesInCols[j] == 1 && mat[i][j] == 1) {
                        specials++;
                        break;
                    }
                }
            }
        }

        return specials;
    }
}