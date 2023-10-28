func countLetters(word string) [26]int {
	letterToFrequency := [26]int{}
	for _, letter := range word {
		letterToFrequency[int(letter-'a')] += 1
	}
	return letterToFrequency
}

func isAnagram(s string, t string) bool {
	letterCountsT := countLetters(t)
	letterCountsS := countLetters(s)

	for idx, freq := range letterCountsS {
		if letterCountsT[idx] != freq {
			return false
		}
	}
	return true
}