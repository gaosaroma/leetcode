import java.util.HashMap;

public class Pow {
    // 计算次方，分治法
    // 一分二，二分四
    // 同时使用hashmap进行记忆

    private static HashMap<String, Double> cache = new HashMap<>();

    public double myPow(double x, int n) {
        double ans = absPow(x, Math.abs(n)); // 这里没有考虑MIN_VALUE的abs情况
        if (n < 0) return 1 / ans;
        return ans;
    }

    private double absPow(double x, int n) {
        if (n == 0) return 1.0d;
        if (n == 1) return x;

        String k = x + "_" + n;
        if (cache.containsKey(k)) {
            return cache.get(k);
        }

        double ans;
        if (n % 2 == 0) {
            ans = absPow(x, n / 2) * absPow(x, n / 2);
        } else {
            ans = x * absPow(x, n / 2) * absPow(x, n / 2);
        }

        cache.put(k, ans);
        return ans;

    }

    public static void main(String[] args) {
        Pow t = new Pow();
        System.out.println(t.myPow(2.000,-2));
    }
}
