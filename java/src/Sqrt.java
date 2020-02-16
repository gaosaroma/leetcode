public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int root = x / mid; // 避免溢出
            if (root < mid) {
                right = mid; // [l,r)
            } else {
                left = mid + 1;
            }
        }
        return left-1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int root = x / mid; // 避免溢出
//
//            if (root == mid) return mid;
//
//            if (root < mid) {
//                right = mid - 1; // [l,r]
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right;
    }

    public static void main(String[] args) {
        Sqrt t = new Sqrt();
        System.out.println(t.mySqrt(4));
    }
}
