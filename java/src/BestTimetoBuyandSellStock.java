public class BestTimetoBuyandSellStock {
    // 找极值
    // 找到price之前最小的买点
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;

        for (int price : prices) {
            sell = Math.max(sell, price - buy);
            buy = Math.min(buy, price);
        }
        return sell;
    }
}
