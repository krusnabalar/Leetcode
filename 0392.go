func isSubsequence(s string, t string) bool {
	if len(s) > len(t) {
		return false
	} else if len(s) == 0 {
		return true
	}

	letterPtr := 0

	for i := 0; i < len(t); i++ {
		if s[letterPtr] == t[i] {
			letterPtr++
			if letterPtr == len(s) {
				return true
			}
		}
	}

	return false
}