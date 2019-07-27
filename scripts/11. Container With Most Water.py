class Solution:
    def maxArea(self, height):
        # Approach1: One-pass
        # Time complexity : O(n^2)
        # Space complexity : O(1)
        # Easiest but high Time Complexity

        maxArea = 0
        for i in range(len(height)):
            for j in range(i + 1, len(height)):
                area = min(height[i], height[j]) * (j - i)
                if area > maxArea:
                    maxArea = area
        return maxArea

        # Approach2: Move the shorter one
        # Time complexity : O(n)
        # Space complexity : O(1)
        # Ideas: when moving the (l,r), how to move is more effective? Move the shorter one.
        #        Because when you are at (l_t,r_t) and plans to move one of them (ps: they respectively have only one way to move),
        #        the area will be larger when move the shorter one.
        #        Moving the longer one does not work.
        # Proof: https://leetcode.com/problems/container-with-most-water/discuss/200246/Proof-by-formula
        # Done: why and when shall we think in this way when encountering such a question?
        #   I guess it happens when we considering what is effective and useless operation in our work.
        #   Just like some operations seems to be supposed done in the process, but actually not.
        #   Just like in our lives for a specific target.

        left = 0
        right = len(height) - 1

        maxArea = 0
        while (left < right):
            maxArea = max(maxArea, (right - left) * min(height[right], height[left]))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return maxArea


if __name__ == '__main__':
    s = Solution()
    print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
