import java.util.*;

class Solution {
    int[][] matrix;
    List<Integer> answer;

    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        this.answer = new ArrayList<Integer>();
        this.matrix = matrix;
        if (r == 1) {
            // add row elements to answer and return
            addRow(0, 0, c - 1, true);
            return answer;
        }
        if (c == 1) {
            // add col elements to answer and return
            addCol(0, r - 1, 0, false);
            return answer;
        }

        int left = 0, right = c - 1, bottom = r - 1, top = 0;
        Boolean leftToRight = true, bottomToTop = false;

        addRow(0, 0, right, leftToRight);
        leftToRight = !leftToRight;

        while (right - left >= 1 && bottom - top >= 1) {
            verticalTraversal(bottom, top, left, right, bottomToTop);
            horizontalTraversal(left, right, bottom, top, leftToRight);
        }

        if (bottom - top == 0)
            return answer;
        verticalTraversal(bottom, top, left, right, bottomToTop);

        return answer;
    }

    private void addRow(int rowNum, int l, int r, Boolean leftToRight) {
        if (leftToRight) {
            for (int i = l; i <= r; i++) {
                answer.add(matrix[rowNum][i]);
            }
        } else {
            for (int i = r; i >= l; i--) {
                answer.add(matrix[rowNum][i]);
            }
        }
    }

    private void addCol(int colNum, int b, int t, Boolean bottomToTop) {
        if (bottomToTop) {
            for (int i = b; i >= t; i--) {
                answer.add(matrix[i][colNum]);
            }
        } else {
            for (int i = t; i <= b; i++) {
                answer.add(matrix[i][colNum]);
            }
        }
    }

    private void verticalTraversal(int bottom, int top, int left, int right, Boolean bottomToTop) {
        if (bottomToTop) {
            addCol(left, bottom - 1, top, bottomToTop);
            bottom--;
        } else {
            addCol(right, bottom, top + 1, bottomToTop);
            top++;
        }
        bottomToTop = !bottomToTop;
    }

    private void horizontalTraversal(int left, int right, int bottom, int top, Boolean leftToRight) {
        if (leftToRight) {
            addRow(top, left + 1, right, leftToRight);
            left++;
        } else {
            addRow(bottom, left, right - 1, leftToRight);
            right--;
        }
        leftToRight = !leftToRight;
    }
}