import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        int numRows = nums.size(), count = 0;

        for (int i = numRows - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int x = i + j;
                if (!groups.containsKey(x)) {
                    groups.put(x, new ArrayList<Integer>());
                }
                groups.get(x).add(nums.get(i).get(j));
                count++;
            }
        }

        int[] res = new int[count];
        int numGroups = groups.keySet().size(), index = 0;
        for (int i = 0; i < numGroups; i++) {
            for (int num : groups.get(i)) {
                res[index] = num;
                index++;
            }
        }
        return res;
    }
}