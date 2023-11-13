package leetcode

func replaceElements(arr []int) []int {
	max := -1
	for i := len(arr) - 1; i > -1; i-- {
		if arr[i] > max {
			max, arr[i] = arr[i], max
		} else {
			arr[i] = max
		}
	}

	return arr
}
