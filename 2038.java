class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0, bobMoves = 0;
        boolean currStreakAlice = colors.charAt(0) == 'A';
        int aliceStreak = 0, bobStreak = 0;
        for (char c : colors.toCharArray()) {
            if (currStreakAlice) {
                bobMoves += Math.max(0, bobStreak - 2);
                bobStreak = 0;
                if (c == 'A') {
                    aliceStreak++;
                } else {
                    currStreakAlice = !currStreakAlice;
                    bobStreak++;
                }
            } else {
                aliceMoves += Math.max(0, aliceStreak - 2);
                aliceStreak = 0;
                if (c == 'B') {
                    bobStreak++;
                } else {
                    currStreakAlice = !currStreakAlice;
                    aliceStreak++;
                }
            }
        }

        bobMoves += Math.max(0, bobStreak - 2);
        aliceMoves += Math.max(0, aliceStreak - 2);
        if (aliceMoves == 0)
            return false;
        if (bobMoves == 0)
            return true;

        return aliceMoves > bobMoves;
    }
}
