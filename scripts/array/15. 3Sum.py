class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Approach1: One-pass Simple List
        # Time complexity : O(n^2)
        # Space complexity : O(1)
        # 模仿自TwoSum，但是超时了...

        wantedSum = []
        result = []
        for i in range(len(nums)):
            wantedSum.append(0 - nums[i])
            wantedNum = {}
            for j in range(i + 1, len(nums)):
                if nums[j] in wantedNum:
                    if wantedNum[nums[j]] != j:
                        temp = [nums[i], nums[wantedNum[nums[j]]], nums[j]]
                        temp.sort()
                        if temp not in result:
                            result.append(temp)
                else:
                    wantedNum[wantedSum[i] - nums[j]] = j
        return result

        # Review Approach1 from Approach2:
        # 其中有很多做了不work（白费力气）的operation，这种有固定的sum也可以想到sort对吧
        # 特别是排序了之后，可以筛除掉重复的
        # 筛除重复的可以比较[i+1]与[i]

        # Approach2: One-pass Faster List
        # Time complexity : O(n^2) 916 ms
        # Space complexity : O(1)

        res = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                _sum = nums[i] + nums[l] + nums[r]
                if _sum < 0:
                    l += 1
                elif _sum > 0:
                    r -= 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    l += 1
                    r -= 1
        return res


if __name__ == '__main__':
    a = Solution()
    result = a.threeSum([-1, 0, 1, 2, -1, -4])
    print(result)
