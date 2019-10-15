class Solution:
    def twoSum(self, nums, target):
        # Approach1: One-pass Simple List
        # Time complexity : O(n) 580ms
        # Space complexity : O(1) 14.8MB
        # 最简单

        len_nums = len(nums)
        for i in range(len_nums):
            check = target - nums.pop(0)
            if check in nums:
                return [i, nums.index(check) + i + 1]

        # Approach2: One-pass Hash Table
        # Time complexity : O(n) 60ms
        # Space complexity : O(n) 15.4MB
        # 时间要快，考虑用Map，遍历一遍，存对应值的Map映射，找的时候Map快

        # Numbers that are needed to meet the target will be stored here along with an index of a complementary number.
        wanted_nums = {}
        # Interating through a list of numbers
        for i in range(len(nums)):

            # If number in wanted_nums it means we've got the sum!
            if nums[i] in wanted_nums:
                return [wanted_nums[nums[i]], i]

            # If not, we store the difference (so the number we seek) along with an index
            else:
                wanted_nums[target - nums[i]] = i


if __name__ == '__main__':
    a = Solution()
    b = a.twoSum([3, 2, 7, 9], 9)
    print(b)
