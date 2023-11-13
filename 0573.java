class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = 0, firstNutDist = Integer.MIN_VALUE;

        for (int[] nut : nuts) {
            ans += l1NormDistance(tree, nut) * 2;
            firstNutDist = Math.max(l1NormDistance(tree, nut) - l1NormDistance(squirrel, nut), firstNutDist);
        }
        return ans - firstNutDist;
    }

    private int l1NormDistance(int[] objectOne, int[] objectTwo) {
        return Math.abs(objectOne[0] - objectTwo[0]) + Math.abs(objectOne[1] - objectTwo[1]);
    }
}