import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int numPairs = adjacentPairs.length;
        if (numPairs == 1)
            return adjacentPairs[0];

        int n = (numPairs - 1) + 2;
        int[] nums = new int[n];

        // create a map of pairs for each unique element of integer array nums
        Map<Integer, List<Integer>> pairMap = new HashMap<Integer, List<Integer>>();
        for (int[] pair : adjacentPairs) {
            List<Integer> first = pairMap.getOrDefault(pair[0], new ArrayList<Integer>());
            List<Integer> second = pairMap.getOrDefault(pair[1], new ArrayList<Integer>());
            first.add(pair[1]);
            second.add(pair[0]);
            pairMap.put(pair[0], first);
            pairMap.put(pair[1], second);
        }

        // fill up first and second value
        for (int uniqueNum : pairMap.keySet()) {
            if (pairMap.get(uniqueNum).size() == 1) {
                nums[0] = uniqueNum;
                nums[1] = pairMap.get(uniqueNum).get(0);
                break;
            }
        }

        // fill in the rest of the elements
        for (int i = 2; i < n; i++) {
            nums[i] = pairMap.get(nums[i - 1]).get(0) == nums[i - 2] ? pairMap.get(nums[i - 1]).get(1)
                    : pairMap.get(nums[i - 1]).get(0);
        }

        return nums;
    }
}