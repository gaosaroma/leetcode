public class ZigZagConversion {
    // 找规律
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder("");
        int len = s.length();
        for (int i = 0; i < numRows; i++) {

            int[] gap = new int[2];

            if (i == 0 || i == numRows - 1) gap[0] = gap[1] = 2 * (numRows - 1);
            else {
                gap[0] = 2 * (numRows - 1 - i);
                gap[1] = 2 * i;
            }

            int cur = i;
            if (cur < len) res.append(s.charAt(cur));

            while (cur + gap[0] < len) {
                cur = cur + gap[0];
                res.append(s.charAt(cur));

                if (cur + gap[1] >= len) break;

                cur = cur + gap[1];
                res.append(s.charAt(cur));
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion tmp = new ZigZagConversion();
        System.out.println(tmp.convert("A", 2));
    }
}
