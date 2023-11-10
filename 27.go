func removeElement(nums []int, val int) int {
	leftPtr := 0
	rightPtr := len(nums) - 1
	newLen := len(nums)

	for leftPtr <= rightPtr {
		if nums[rightPtr] == val {
			newLen--
			rightPtr--
			continue
		}

		if nums[leftPtr] == val {
			newLen--
			nums[leftPtr] = nums[rightPtr]
			rightPtr--
		}
		leftPtr++
	}

	return newLen
}