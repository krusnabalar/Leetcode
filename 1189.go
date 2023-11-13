package leetcode

func maxNumberOfBalloons(text string) int {

	buckets := make([]int, 5)

	for _, letter := range text {
		switch letter {
		case 'b':
			buckets[0]++
		case 'a':
			buckets[1]++
		case 'l':
			buckets[2]++
		case 'o':
			buckets[3]++
		case 'n':
			buckets[4]++
		}
	}

	balloonCount := 0

	for buckets[0] > 0 && buckets[1] > 0 && buckets[2] > 1 && buckets[3] > 1 && buckets[4] > 0 {
		buckets[0]--
		buckets[1]--
		buckets[2] -= 2
		buckets[3] -= 2
		buckets[4]--
		balloonCount++
	}

	return balloonCount
}
