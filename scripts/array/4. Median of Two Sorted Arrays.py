import math


class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Approach1: One-pass Median
        # Time complexity : O(m+n) 104ms
        # Space complexity : O(1) 14.2MB
        # 最简单，但达不到题目要求的O(log(m+n))复杂度

        index = math.floor((len(nums1) + len(nums2)) / 2)
        needCal = True if (len(nums1) + len(nums2)) % 2 == 0 else False
        temp_n1 = 0
        temp_n2 = 0
        len_n1 = len(nums1)
        len_n2 = len(nums2)
        sorted_nums = []
        for i in range(index + 1):
            if temp_n1 < len_n1 and (temp_n2 >= len_n2 or nums1[temp_n1] <= nums2[temp_n2]):
                if i > index - 2:
                    sorted_nums.append(nums1[temp_n1])
                temp_n1 += 1
            else:
                if i > index - 2:
                    sorted_nums.append(nums2[temp_n2])
                temp_n2 += 1

        if needCal:
            return (sorted_nums[-1] + sorted_nums[-2]) / 2
        else:
            return sorted_nums[-1]

        # Approach2: Dichotomy
        # Time complexity : O(log(m+n))
        # Space complexity : O(1)

        # 这里写太慢了；原因：设计的时候，应该注重临界点去设计
        # 写了很久，想写一个可以一遍把最后两个都拿出来的；结果代码很丑。。

        # 分情况：a. k==1; 则最后一个好取，但倒数第二个要在nums1与nums2里面已经舍去的部分的最大值，所以记录了max1与max2；
        #         b. k>1; 则如果存在一个列表(e.g. nums1)已经舍去完全，则最后一个在另一个列表(nums2)中，同样，倒数第二个存在于：nums1的已经舍去的最大值max1与nums2的k-1个值之间的最大值
        #                   如果两个列表都没有舍去完全，则正常二分法舍去

        # 可以参考一下人家代码：https://leetcode.wang/leetCode-4-Median-of-Two-Sorted-Arrays.html 虽然是递归求值
        # 在写这份代码的时候，其实涉及很多次关于边界的比较；事实是，如果既定：A边界比B要近，则只需要比较A就可以；
        # 所以在人家的代码里，用函数迭代求值的时候，会把A和B先作比较，然后再按照既定规则，只需要比较A，代码简洁很多

        index = math.floor((len(nums1) + len(nums2)) / 2)
        needCal = True if (len(nums1) + len(nums2)) % 2 == 0 else False
        len_n1 = len(nums1)
        len_n2 = len(nums2)
        sorted_nums = []

        temp_n1 = temp_n2 = -1
        k = index + 1  # k表示是第几个数字，从1开始算
        max1 = max2 = 0  # max1与max2分别表示nums1与nums2已经舍去里的最大值
        while k > 0:
            # k=1，即要取的最后一个
            if k == 1:
                sorted_nums.append(max(max1, max2))  # 取nums1与nums2里面最大的
                if temp_n1 + 1 >= len_n1:
                    sorted_nums.append(nums2[temp_n2 + 1])
                    break
                if temp_n2 + 1 >= len_n2:
                    sorted_nums.append(nums1[temp_n1 + 1])
                    break
                sorted_nums.append(min(nums1[temp_n1 + 1], nums2[temp_n2 + 1]))
                break

            # nums1舍去完了
            if temp_n1 + 1 >= len_n1:
                sorted_nums.append(max(max1, nums2[temp_n2 + k - 1]))
                sorted_nums.append(nums2[temp_n2 + k])
                break

            # nums2舍去完了
            if temp_n2 + 1 >= len_n2:
                sorted_nums.append(max(max2, nums1[temp_n1 + k - 1]))
                sorted_nums.append(nums1[temp_n1 + k])
                break

            # 正常二分法
            skew1 = skew2 = math.floor(k / 2)

            skew1 = min(skew1, len_n1 - 1 - temp_n1)
            skew2 = min(skew2, len_n2 - 1 - temp_n2)

            if nums1[temp_n1 + skew1] < nums2[temp_n2 + skew2]:
                max1 = nums1[temp_n1 + skew1]
                k -= skew1
                temp_n1 += skew1
            else:
                max2 = nums2[temp_n2 + skew2]
                k -= skew2
                temp_n2 += skew2

        if needCal:
            return (sorted_nums[-1] + sorted_nums[-2]) / 2
        else:
            return sorted_nums[-1]
        # review Approach4:
        # 这个代码完全可以Refine，分大类；比如说：结束条件 与 未结束条件
        # k == 1, temp_n1 + 1 >= len_n1,temp_n2 + 1 >= len_n2归为一类
        # 用组合的方式去看

        # Approach3: Dichotomy
        # Time complexity : O(log(m+n))
        # Space complexity : O(1)
        # 参考人家代码：https://leetcode.wang/leetCode-4-Median-of-Two-Sorted-Arrays.html 求两次值，精简很多

        len_n1 = len(nums1)
        len_n2 = len(nums2)

        # 把两种情况合并；按照数学的思维来说，这种更加精简
        left = math.floor((len_n1 + len_n2 + 1) / 2)
        right = math.floor((len_n1 + len_n2 + 2) / 2)

        return (self.getKth(nums1, 0, len_n1 - 1, nums2, 0, len_n2 - 1, left) + self.getKth(nums1, 0, len_n1 - 1,
                                                                                            nums2,
                                                                                            0, len_n2 - 1,
                                                                                            right) / 2)

        # Approach4: Dichotomy
        # Time complexity : O(log(min(m,n)))
        # Space complexity : O(1)

        len_n1 = len(nums1)
        len_n2 = len(nums2)

        # 保证len_n1<len_n2，所以复杂度为：log(min(m,n))
        if len_n1 > len_n2:
            return self.findMedianSortedArrays(nums2, nums1)

        # 二分法找i，所以设置i_min与i_max -> i与j一一对应
        i_min = 0
        i_max = len_n1
        needCal = True if (len_n1 + len_n2) % 2 == 0 else False
        sorted_nums = []

        while i_min <= i_max:
            i = math.floor((i_min + i_max) / 2)
            j = math.floor((len_n1 + len_n2 + 1) / 2) - i

            # 情况分为：正在找i和找到i；
            if j != 0 and i != len_n1 and nums1[i] < nums2[j - 1]:
                i_min = i_min + 1
            elif i != 0 and j != len_n2 and nums1[i - 1] > nums2[j]:
                i_max = i_max - 1
            else:
                # 满足要求，找到i：
                # i==0或者j==0或者i==len_n1或者j==len_n2或者i_min=i_max

                # 找左边的
                if i == 0:
                    sorted_nums.append(nums2[j - 1])
                elif j == 0:
                    sorted_nums.append(nums1[i - 1])
                else:
                    sorted_nums.append(max(nums1[i - 1], nums2[j - 1]))

                # 找右边的
                if needCal:
                    if i == len_n1:
                        sorted_nums.append(nums2[j])
                    elif j == len_n2:
                        sorted_nums.append(nums1[i])
                    else:
                        sorted_nums.append(min(nums1[i], nums2[j]))

                    return (sorted_nums[-1] + sorted_nums[-2]) / 2
                else:
                    return sorted_nums[-1]

    def getKth(self, nums1, start1, end1, nums2, start2, end2, k):
        len1 = end1 - start1 + 1
        len2 = end2 - start2 + 1

        # 保证len1<len2
        if (len1 > len2): return self.getKth(nums2, start2, end2, nums1, start1, end1, k)

        # 如果nums1舍去完了
        if (len1 == 0): return nums2[start2 + k - 1]

        # 没有舍去完
        if (k == 1): return min(nums1[start1], nums2[start2])

        i = start1 + min(len1, k / 2) - 1
        j = start2 + min(len2, k / 2) - 1

        if (nums1[i] > nums2[j]):
            return self.getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1))
        else:
            return self.getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1))


if __name__ == '__main__':
    a = Solution()
    b = a.findMedianSortedArrays([], [1])
    print(b)
