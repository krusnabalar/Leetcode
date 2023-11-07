func longestCommonPrefix(strs []string) string {
	if len(strs) < 1 {
		return ""
	} else if len(strs) < 2 {
		return strs[0]
	}
	currLongest := strs[0]

	for i := 1; i < len(strs); i++ {
		currStr := strs[i]
		broken := false
		for j := 0; j < len(currLongest) && j < len(currStr); j++ {
			if currLongest[j] != currStr[j] {
				currLongest = currStr[:j]
				broken = true
				break
			}
		}

		if !broken && len(currStr) < len(currLongest) {
			currLongest = currStr
		}
	}

	return currLongest

}