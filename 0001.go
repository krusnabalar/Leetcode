package leetcode

func twoSum(nums []int, target int) []int {
	complementToIndex := make(map[int]int)
	for idx, num := range nums {
		compIdx, ok := complementToIndex[target-num]
		if !ok {
			complementToIndex[num] = idx
			continue
		}
		return []int{compIdx, idx}
	}
	return nil
}
