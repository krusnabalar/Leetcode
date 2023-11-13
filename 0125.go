package leetcode

import "unicode"

func isValidPalindrome(s string) bool {
	i := 0
	j := len(s) - 1

	for i < j {
		leftLetter := unicode.ToLower(rune(s[i]))
		rightLetter := unicode.ToLower(rune(s[j]))

		if !unicode.IsLetter(leftLetter) && !unicode.IsDigit(leftLetter) {
			i++
			continue
		}

		if !unicode.IsLetter(rightLetter) && !unicode.IsDigit(rightLetter) {
			j--
			continue
		}

		if leftLetter != rightLetter {
			return false
		}

		i++
		j--
	}

	return true
}
