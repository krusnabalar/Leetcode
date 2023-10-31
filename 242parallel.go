func countLetters(word string, c chan [26]int) {
	letterToFrequency := [26]int{}
	for _, letter := range word {
		letterToFrequency[int(letter-'a')] += 1
	}
	c <- letterToFrequency
}

func isAnagram(s string, t string) bool {
	chanS := make(chan [26]int)
	chanT := make(chan [26]int)

	go countLetters(t, chanT)
	go countLetters(s, chanS)

	letterCountsS := <-chanS
	letterCountsT := <-chanT

	for idx, freq := range letterCountsS {
		if letterCountsT[idx] != freq {
			return false
		}
	}
	return true
}