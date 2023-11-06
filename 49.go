func groupAnagrams(strs []string) [][]string {
	wordToGroup := make(map[[26]byte][]string, len(strs))

	for _, word := range strs {
		var letterFrequency [26]byte
		for _, letter := range word {
			letterFrequency[letter-'a']++
		}
		wordToGroup[letterFrequency] = append(wordToGroup[letterFrequency], word)
	}

	anagramGroups := make([][]string, len(wordToGroup))
	idx := 0
	for _, wordList := range wordToGroup {
		anagramGroups[idx] = wordList
		idx++
	}

	return anagramGroups
}