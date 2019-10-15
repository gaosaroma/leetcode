class Solution:
    def fourSum(self, nums, target):
        # derive from 3Sum
        # IDEAS:
        # a. like recurrence: from 2Sum to 3Sum to 4Sum to NSum ...
        # b. to faster and avoid repeat: skip some tested nums[i] check for every recurrence
        # c.
        res = []
        nums.sort()
        for i in range(len(nums) - 3):
            # to faster and avoid repeat:
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, len(nums) - 2):
                # to faster and avoid repeat:
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                l, r = j + 1, len(nums) - 1
                while l < r:
                    _sum = nums[i] + nums[j] + nums[l] + nums[r]

                    if _sum < target:
                        l += 1
                    elif _sum > target:
                        r -= 1
                    else:
                        res.append([nums[i], nums[j], nums[l], nums[r]])
                        # to faster and avoid repeat:
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        l += 1
                        r -= 1
        return res


if __name__ == '__main__':
    a = Solution()
    nums = [-1,2,2,-5,0,-1,4]
    target = 3
    res = a.fourSum(nums, target)
    print(res)
