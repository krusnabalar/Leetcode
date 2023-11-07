func topKFrequent(nums []int, k int) []int {
	numFreqs := make(map[int]byte, len(nums))
	for _, num := range nums {
		numFreqs[num]++
	}
	buckets := make([][]int, len(nums)+1)
	for num, freq := range numFreqs {
		buckets[freq] = append(buckets[freq], num)
	}
	top_k := make([]int, 0, k)
	for i := len(buckets) - 1; i > 0 && k > 0; i-- {
		if len(buckets[i]) > 0 {
			if len(buckets[i]) > k {
				top_k = append(top_k, buckets[i][:k]...)
				k = 0
			} else {
				top_k = append(top_k, buckets[i]...)
				k -= len(buckets[i])
			}
		}
	}
	return top_k
}