from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complement_to_index = dict()
        for idx, num in enumerate(nums):
            if num not in complement_to_index:
                complement_to_index[target - num] = idx
            else:
                return [complement_to_index[num], idx]