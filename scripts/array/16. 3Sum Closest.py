class Solution:
    def threeSumClosest(self, nums, target):
        # derive from threeSum
        nums.sort()
        if (len(nums) <= 3):
            return sum(nums)

        if nums[0] + nums[1] + nums[2] > target:
            return nums[0] + nums[1] + nums[2]

        if nums[-1] + nums[-2] + nums[-3] < target:
            return nums[-1] + nums[-2] + nums[-3]

        res = nums[0] + nums[1] + nums[2]
        for i in range(len(nums) - 2):
            l, r = i + 1, len(nums) - 1
            while l < r:
                _sum = nums[i] + nums[l] + nums[r]
                if abs(res - target) > abs(_sum - target):
                    res = _sum

                if _sum > target:
                    r -= 1
                else:
                    l += 1

        return res


if __name__ == '__main__':
    a = Solution()
    nums = [0,2,1,-3]
    target = 1
    result = a.threeSumClosest(nums, target)
    print(result)
