class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int palindrome = 0, xTemp = x;
        while (xTemp > 0) {
            palindrome = palindrome * 10 + xTemp % 10;
            xTemp /= 10;
        }
        return x == palindrome;
    }
}