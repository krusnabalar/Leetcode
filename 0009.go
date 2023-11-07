func isPalindrome(x int) bool {

	if x < 0 {
		return false
	}

	y := make([]int, 0)

	for x > 0 {
		y = append(y, x%10)
		x = int(x / 10)
	}

	for i := 0; i < len(y)/2; i++ {
		if y[i] != y[len(y)-1-i] {
			return false
		}
	}

	return true
}