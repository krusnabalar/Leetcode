package leetcode

func lengthOfLongestSubstring(s string) int {

	maxLength := 0
	lettersMap := make(map[byte]int)
	left := 0

	for right := 0; right < len(s); right++ {
		char := s[right]
		idx, ok := lettersMap[char]

		if !ok || idx < left {
			lettersMap[char] = right
		} else {
			left = idx + 1
			lettersMap[char] = right
		}

		if right-left+1 > maxLength {
			maxLength = right - left + 1
		}

	}
	return maxLength
}
