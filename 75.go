func sortColors(nums []int) {
	red := 0
	blue := len(nums) - 1
	for ptr := 0; ptr <= blue; ptr++ {
		if nums[ptr] == 0 {
			nums[ptr], nums[red] = nums[red], nums[ptr]
			red++
		} else if nums[ptr] == 2 {
			nums[ptr], nums[blue] = nums[blue], nums[ptr]
			blue--
			ptr--
		}
	}
}