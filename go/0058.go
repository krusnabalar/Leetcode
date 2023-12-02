package leetcode

func lengthOfLastWord(s string) int {
	if len(s) < 2 {
		return len(s)
	}
	lastLetterIndex := -1
	for i := len(s) - 1; i >= 0; i-- {
		if lastLetterIndex == -1 {
			if s[i] != ' ' {
				lastLetterIndex = i
			}
		} else if s[i] == ' ' {
			return lastLetterIndex - i
		}
	}
	return lastLetterIndex + 1
}
