package leetcode

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	ans := make([]int, len(nums1))
	indexOf := make(map[int]int, len(nums1))
	searchList := make([]int, 0)

	for index, num := range nums1 {
		indexOf[num] = index
	}

	for _, num := range nums2 {

		for i := 0; i < len(searchList); i++ {
			toBeat := searchList[i]
			if num > toBeat {
				ans[indexOf[toBeat]] = num
				searchList[i] = searchList[len(searchList)-1]
				searchList = searchList[:len(searchList)-1]
				i--
			}
		}

		_, ok := indexOf[num]

		if ok {
			searchList = append(searchList, num)
		}
	}

	for _, num := range searchList {
		ans[indexOf[num]] = -1
	}

	return ans
}
