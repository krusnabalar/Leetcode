package leetcode

func countLettersParallel(word string, c chan [26]int) {
	letterToFrequency := [26]int{}
	for _, letter := range word {
		letterToFrequency[int(letter-'a')] += 1
	}
	c <- letterToFrequency
}

func isAnagramParallel(s string, t string) bool {
	chanS := make(chan [26]int)
	chanT := make(chan [26]int)

	go countLettersParallel(t, chanT)
	go countLettersParallel(s, chanS)

	letterCountsS := <-chanS
	letterCountsT := <-chanT

	for idx, freq := range letterCountsS {
		if letterCountsT[idx] != freq {
			return false
		}
	}
	return true
}
