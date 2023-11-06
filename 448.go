func findDisappearedNumbers(nums []int) []int {
	buckets := make([]int, len(nums))
	ans := make([]int, 0)
	for _, num := range nums {
		buckets[num-1] += 1
	}

	for numMinusOne, count := range buckets {
		if count == 0 {
			ans = append(ans, numMinusOne+1)
		}
	}

	return ans
}