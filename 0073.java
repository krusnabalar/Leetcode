class Solution {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        Boolean isCol = false;

        for (int i = 0; i < numRows; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < numCols; j++) matrix[0][j] = 0;
        }

        if (isCol) {
            for (int i = 0; i < numRows; i++) matrix[i][0] = 0;
        }
    }
}
