

func isValid(s string) bool {
	pairs := map[rune]rune{
		'}': '{',
		']': '[',
		')': '(',
	}

	stack := make([]rune, 0)

	for _, bracket := range s {
		pair, ok := pairs[bracket]
		if !ok {
			stack = append(stack, bracket)
			continue
		}
		if len(stack) == 0 {
			return false
		}
		if stack[len(stack)-1] != pair {
			return false
		}
		stack = stack[:len(stack)-1]
	}
	return len(stack) == 0
}