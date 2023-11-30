class Solution {
    public int buyChoco(int[] prices, int money) {
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minOne) {
                minTwo = minOne;
                minOne = price;
            } else if (price < minTwo) {
                minTwo = price;
            }
        }

        return money - (minOne + minTwo) < 0 ? money : money - (minOne + minTwo);
    }
}