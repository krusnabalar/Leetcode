package leetcode

func pivotIndex(nums []int) int {
	sumLeft := 0
	sumRight := 0

	for i := 0; i < len(nums); i++ {
		sumRight += nums[i]
	}

	for i := 0; i < len(nums); i++ {
		sumRight -= nums[i]

		if sumLeft == sumRight {
			return i
		}

		sumLeft += nums[i]
	}

	return -1

}
