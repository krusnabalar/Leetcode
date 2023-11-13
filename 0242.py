from collections import defaultdict
from typing import Dict

class Solution:
    def countLetters(self, s: str) -> Dict[str, int]:
        letter_counts = defaultdict(int)
        for letter in s:
            letter_counts[letter] += 1
        return letter_counts

    def isAnagram(self, s: str, t: str) -> bool:
        letters_s = self.countLetters(s)
        letters_t = self.countLetters(t)
        return letters_s == letters_t            