from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        for word in strs:
            letter_counts = [0] * 26
            for letter in word:
                letter_counts[ord(letter) - ord("a")] += 1
            groups[tuple(letter_counts)].append(word)
        return groups.values()