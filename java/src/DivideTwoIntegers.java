public class DivideTwoIntegers {
    // binary search
    // 在任何顺序排列的数组中，搜寻一个数字，都可以用二分法查找。
    // 1. 確定查找判断的边界（mid * divisor与dividend进行比较）
    // 2. 确定边界（正负和LONG）-》 注意mid计算时：(left+right)/2改成left+(right-left)/2
    // 3. 其它细节[bitMulti, INT_MIN与INT_MAX
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        if (divisor == 1) return dividend;

        long sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long absDivd = Math.abs((long)dividend),absDivs=Math.abs((long)divisor);
        // 这里要强制转成long，因为如果dividend=MIN_V，Math.abs之后还是负的
        long left = 1, right = absDivd, ans = 0;

        while (left < right) {
            long mid = left + ((right - left) >> 1); // 注意运算顺序，要加括号
            long res = bitMulti(mid, absDivs);

            if (res > absDivd) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 控制为 [l,r]
        // while(left <= right)
        // if(==) return mid;
        // if(>) right = mid-1;
        // if(<) left = mid+1;
        // return right;

        // 或者控制为[l,r)
        // while(left < right)
        // if(>) right = mid;
        // if(<) left = mid+1;
        // return right;
        ans = sign * (left - 1);
        return (int) ans;
    }

    private long bitMulti(long a, long b) {
        long res = 0;
        while (b != 0) {
            if ((b & 1L) == 1) res += a;
            a <<= 1;
            b >>= 1;

        }
        return res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(-2147483648,2));
    }

}
