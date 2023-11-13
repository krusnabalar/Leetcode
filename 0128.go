package leetcode

func longestConsecutive(nums []int) int {
	numSet := make(map[int]struct{})

	for _, num := range nums {
		if _, ok := numSet[num]; !ok {
			numSet[num] = struct{}{}
		}
	}

	maxLen := 0

	for num := range numSet {
		if _, ok := numSet[num-1]; !ok {
			curr := num
			ok = true
			for ok {
				curr++
				_, ok = numSet[curr]
			}
			if curr-num > maxLen {
				maxLen = curr - num
			}
		}
	}
	return maxLen
}
