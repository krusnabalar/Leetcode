import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> singleNums = new HashSet<>();
        Set<Integer> allNums = new HashSet<>();

        for (int num : nums) {
            if (allNums.add(num)) {
                singleNums.add(num);
            } else {
                singleNums.remove(num);
            }
        }

        for (int num : singleNums)
            return num;
        return -1;
    }
}