public class Lab2b {
    static int maxProfit;

    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            maxProfit = 0;
            return;
        }

        int[] profitLeft = new int[n];
        int[] profitRight = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]);
        }

        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]);
        }
    }

    public static void main(String[] args) {
        int[] prices1 = {20, 30, 45, 60, 75, 70};
        findMaxProfit(prices1);
        System.out.println("Max Profit: " + maxProfit);

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        findMaxProfit(prices2);
        System.out.println("Max Profit: " + maxProfit);
    }
}
