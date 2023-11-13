package leetcode

type void struct{}

func containsDuplicate(nums []int) bool {
	numsSet := map[int]void{}
	for _, num := range nums {
		_, ok := numsSet[num]
		if !ok {
			numsSet[num] = void{}
			continue
		}
		return true
	}
	return false
}
