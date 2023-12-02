package leetcode

func majorityElement(nums []int) int {
	numCount := make(map[int]int, len(nums))
	for _, num := range nums {
		numCount[num]++
	}
	for num, count := range numCount {
		if count > len(nums)/2 {
			return num
		}
	}
	return -1
}
