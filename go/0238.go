package leetcode

func productExceptSelf(nums []int) []int {
	products := make([]int, len(nums))

	temp_products := 1
	for idx := 0; idx < len(nums); idx++ {
		products[idx] = temp_products
		temp_products *= nums[idx]
	}

	temp_products = 1
	for idx := len(products) - 2; idx >= 0; idx-- {
		temp_products *= nums[idx+1]
		products[idx] *= temp_products
	}

	return products
}
