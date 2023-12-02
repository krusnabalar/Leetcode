class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [0 for i in range(len(nums))]
        output[0] = nums[0]
        for i in range(1,len(nums)):
            output[i] = output[i-1] * nums[i]
        right_multiplier = 1
        for i in range(len(nums)-1, 0, -1):
            output[i] = output[i-1] * right_multiplier
            right_multiplier *= nums[i]
        output[0] = right_multiplier
        return output
