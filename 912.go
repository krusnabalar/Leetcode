func merge(arr1, arr2 []int) []int {
	newArr := make([]int, len(arr1)+len(arr2))
	ptr1 := 0
	ptr2 := 0
	for i := 0; i < len(newArr); i++ {
		if ptr1 >= len(arr1) {
			newArr[i] = arr2[ptr2]
			ptr2++
			continue
		}
		if ptr2 >= len(arr2) {
			newArr[i] = arr1[ptr1]
			ptr1++
			continue
		}
		if arr1[ptr1] < arr2[ptr2] {
			newArr[i] = arr1[ptr1]
			ptr1++
		} else {
			newArr[i] = arr2[ptr2]
			ptr2++
		}
	}

	return newArr
}

func sortArray(nums []int) []int {
	if len(nums) > 1 {
		return merge(sortArray(nums[:len(nums)/2]), sortArray(nums[len(nums)/2:]))
	} else {
		return nums
	}
}