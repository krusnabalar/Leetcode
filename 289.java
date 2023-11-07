class Solution {
    int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        // encode cell values from 0 to x and 1 to 1x,
        // where x is the number of live cells neighboring
        // the current cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                encodeCurrentState(i, j);
            }
        }

        // update cell values according to the 4 rules,
        // and change them back to either 0 or 1
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                updateState(i, j);
            }
        }
    }

    void encodeCurrentState(int i, int j) {
        board[i][j] *= 10;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int neighborR = i + r;
                int neighborC = j + c;

                // check if the neighbor cell being checked is valid
                if (neighborR >= 0 && neighborR < board.length && neighborC >= 0 && neighborC < board[0].length
                        && !(r == 0 && c == 0)) {
                    int cellVal = board[neighborR][neighborC];
                    if (r == -1 || (r == 0 && c == -1))
                        cellVal /= 10;
                    board[i][j] += cellVal;
                }
            }
        }
    }

    void updateState(int i, int j) {
        Boolean isLive = board[i][j] / 10 == 1;
        int liveNeighborCount = board[i][j] % 10;

        // apply cell update rules
        if (isLive) {
            if (liveNeighborCount < 2 || liveNeighborCount > 3) {
                board[i][j] = 0;
            } else {
                board[i][j] = 1;
            }
        } else if (liveNeighborCount == 3) {
            board[i][j] = 1;
        } else {
            board[i][j] /= 10;
        }
    }
}