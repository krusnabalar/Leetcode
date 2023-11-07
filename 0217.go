type void struct{}

func containsDuplicate(nums []int) bool {
	numsSet := map[int]void{}
	for _, num := range nums {
		_, ok := nums_set[num]
		if !ok {
			numsSet[num] = void{}
			continue
		}
		return true
	}
	return false
}