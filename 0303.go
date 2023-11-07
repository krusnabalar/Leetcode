type NumArray struct {
	numSum []int
}

func Constructor(nums []int) NumArray {
	newArray := make([]int, len(nums)+1)
	for i, num := range nums {
		newArray[i+1] = num + newArray[i]
	}
	return NumArray{newArray}
}

func (this *NumArray) SumRange(left int, right int) int {
	return this.numSum[right+1] - this.numSum[left]
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */