public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
//        Approach1: 迭代
//        return rotatedSearch(nums, 0, nums.length - 1, target);

//        Approach1:不用迭代
//        不用迭代，双指针也可以有迭代，二分法的效果
//        要注意的地方：[l,r]之间都有可能是target的东西，所以[mid+1,r];[l,mid-1]，注意l>r判断
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = nums[(l + r) / 2];
            if (mid == target) return mid;

//        keys: 分类讨论
            if (mid > nums[r]) {
                if (target < mid && target >= nums[l]) {
                    r = (l + r) / 2 - 1;
                } else {
                    l = (l + r) / 2 + 1;
                }
            } else {
                if (target > mid && target <= nums[r]) {
                    l = (l + r) / 2 + 1;
                } else {
                    r = (l + r) / 2 - 1;
                }
            }
        }
        return -1;
    }

    private int rotatedSearch(int[] nums, int l, int r, int target) {
        if (l > r) return -1; // 关于迭代出现->(l+r)/2+1 or (l+r)/2-1 -> 记得判断l>r
        if (nums[l] < nums[r]) return binarySearch(nums, l, r, target); // 防止旋转点为0

//        keys: 分类讨论
        int mid = nums[(l + r) / 2];
        if (mid > nums[r]) {
            if (target <= mid && target >= nums[l]) return binarySearch(nums, l, (l + r) / 2, target);
            return rotatedSearch(nums, (l + r) / 2 + 1, r, target);
        } else {
            if (target >= mid && target <= nums[r]) return binarySearch(nums, (l + r) / 2, r, target);
            return rotatedSearch(nums, l, (l + r) / 2 - 1, target);
        }
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
//        keys: 每次搜的都是：[l,r]之间都有可能是target的东西，所以[mid+1,r];[l,mid-1]
//        同时，检查l>r
        if (target > nums[r] || target < nums[l] || l > r) return -1;

        int mid = nums[(l + r) / 2];

        if (mid == target) return (l + r) / 2;
        if (mid < target) return binarySearch(nums, (l + r) / 2 + 1, r, target);
        return binarySearch(nums, l, (l + r) / 2 - 1, target);
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(test.search(nums, 3));
    }
}
