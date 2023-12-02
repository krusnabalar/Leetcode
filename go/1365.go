package leetcode

func smallerNumbersThanCurrent(nums []int) []int {
	buckets := make([]int, 101)
	for _, num := range nums {
		buckets[num]++
	}
	var smallerThan int
	for idx, count := range buckets {
		buckets[idx] = smallerThan
		smallerThan += count
	}
	for idx, num := range nums {
		nums[idx] = buckets[num]
	}
	return nums
}
