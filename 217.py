from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        buckets = set()
        for num in nums:
            if num in buckets:
                return True
            buckets.add(num)
        return False