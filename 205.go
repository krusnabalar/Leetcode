func isIsomorphic(s string, t string) bool {
	forwardMap := make(map[byte]byte)
	backwardMap := make(map[byte]byte)
	for i := 0; i < len(s); i++ {
		forwardValue, forwardOk := forwardMap[s[i]]
		backwardValue, backwardOk := backwardMap[t[i]]
		if backwardOk != forwardOk {
			return false
		} else if forwardOk && (forwardValue != t[i] || backwardValue != s[i]) {
			return false
		} else if !forwardOk {
			forwardMap[s[i]] = t[i]
			backwardMap[t[i]] = s[i]
		}
	}
	return true
}