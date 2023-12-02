import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int numRows = 9, numCols = 9, numBoxes = 9, gridSplit = 3;
        HashSet<Character>[] rows = new HashSet[numRows];
        HashSet<Character>[] cols = new HashSet[numCols];
        HashSet<Character>[] boxes = new HashSet[numBoxes];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        char val;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                val = board[r][c];
                if (val == '.')
                    continue;
                if (!rows[r].add(val))
                    return false;
                if (!cols[c].add(val))
                    return false;
                int boxNum = 3 * (r / gridSplit) + (c / gridSplit);
                if (!boxes[boxNum].add(val))
                    return false;
            }
        }
        return true;
    }
}