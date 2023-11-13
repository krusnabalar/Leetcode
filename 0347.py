from typing import List
from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_to_count = defaultdict(int)
        count_to_nums = [[] for i in range(len(nums) + 1)]
        for num in nums:
            num_to_count[num] += 1
        for num, count in num_to_count.items():
            count_to_nums[count].append(num)
        top_k = []
        for idx in range(len(count_to_nums) - 1, 0, -1):
            for num in count_to_nums[idx]:
                top_k.append(num)
                if len(top_k) == k:
                    return top_k



                
