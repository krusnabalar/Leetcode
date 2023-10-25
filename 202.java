import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNums = new HashSet<>();
        int sum = 0;
        while (n != 1 && !seenNums.contains(n)) {
            int temp = n;
            seenNums.add(n);

            while (temp > 0) {
                sum += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            n = sum;
            sum = 0;
        }

        return n == 1;
    }
}