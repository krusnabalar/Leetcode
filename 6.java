class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || n == 1)
            return s;

        numRows = Math.min(n, numRows);
        int zigJump = 2 * (numRows - 1), zagJump = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int idx = i;
            output.append(s.charAt(idx));
            while (idx < n) {
                if (idx + zigJump >= n)
                    break;
                idx += zigJump;
                if (zigJump > 0) {
                    output.append(s.charAt(idx));
                }

                if (idx + zagJump >= n)
                    break;
                idx += zagJump;
                if (zagJump > 0) {
                    output.append(s.charAt(idx));
                }
            }
            zigJump -= 2;
            zagJump += 2;
        }

        return output.toString();
    }
}