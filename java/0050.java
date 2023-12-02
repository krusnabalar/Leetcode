class Solution {
    private double binaryExp(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1.0 / x;
            n = -1 * n;
        }
        double res = 1;
        while (n != 0) {
            if (n % 3 == 2) {
                res *= x * x;
                n -= 2;
            } else if (n % 3 == 1) {
                res *= x;
                n -= 1;
            }
            x = x * x * x;
            n = n / 3;
        }
        return res;
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}