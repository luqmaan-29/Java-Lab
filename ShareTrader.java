public class ShareTrader {
    // Static variable to store the maximum profit
    static int maxProfit;

    // Static method to find the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            maxProfit = 0;
            return;
        }

        // Arrays to store max profit until day i (from left) and from day i (from right)
        int[] profitLeft = new int[n];
        int[] profitRight = new int[n];

        // Step 1: Calculate max profit for one transaction from left to right
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); // Minimum price seen so far
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice);
        }

        // Step 2: Calculate max profit for one transaction from right to left
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]); // Maximum price seen so far
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]);
        }

        // Step 3: Calculate maximum profit by summing both transactions
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]);
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {20,30,45,60,75,70};
        findMaxProfit(prices1);
        System.out.println("Max Profit: " + maxProfit); // Output: 87

        // Test Case 2
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        findMaxProfit(prices2);
        System.out.println("Max Profit: " + maxProfit); // Output: 100
    }
}

