class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int res = arr[0];
        if (k >= n)
            k = n - 1;

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (res > arr[i + 1]) {
                count++;
            } else {
                count = 1;
                res = arr[i + 1];
            }
            if (count == k)
                return res;
        }

        return res;
    }
}