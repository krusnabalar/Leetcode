func removeDuplicates(nums []int) int {
	previous := nums[0]
	newLen := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != previous {
			nums[newLen] = nums[i]
			newLen++
		}
		previous = nums[i]
	}

	return newLen
}