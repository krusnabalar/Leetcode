import java.util.*;

class SparseVector {
    List<int[]> idxVal;

    SparseVector(int[] nums) {
        idxVal = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                idxVal.add(new int[] { i, nums[i] });
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0, p1 = 0, p2 = 0;
        while (p1 < idxVal.size() && p2 < vec.idxVal.size()) {
            if (idxVal.get(p1)[0] == vec.idxVal.get(p2)[0]) {
                res += idxVal.get(p1)[1] * vec.idxVal.get(p2)[1];
                p1++;
                p2++;
            } else if (idxVal.get(p1)[0] < vec.idxVal.get(p2)[0]) {
                p1++;
            } else {
                p2++;
            }
        }

        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);