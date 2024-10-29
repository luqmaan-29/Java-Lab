public class Lab2b {
    static int maxProfit;

    public static void findMaxProfit(int[] prices) {
        int n = prices.length;

        if (n < 2) {
            maxProfit = 0;
            return;
        }

        int minPrice = prices[0];
        int maxPrice = prices[n - 1];

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }

            int profit = maxPrice - prices[i];

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
    }

    public static void main(String[] args) {
        int[] prices1 = {20, 30, 45, 60, 75, 70};
        findMaxProfit(prices1);
        System.out.println("Max Profit: " + maxProfit);

        maxProfit = 0;

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        findMaxProfit(prices2);
        System.out.println("Max Profit: " + maxProfit);
    }
}
