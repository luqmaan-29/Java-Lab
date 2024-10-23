public class Lab2b {
    // Variable to store the maximum profit from transactions
    static int maxProfit;

    // Method to find the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;  // Get the number of days
        if (n < 2) {  // If there are less than 2 days, no profit can be made
            maxProfit = 0;
            return;
        }

        // Arrays to track the maximum profit from left to right and right to left
        int[] profitLeft = new int[n];  // Profit from the first transaction
        int[] profitRight = new int[n]; // Profit from the second transaction

        // Step 1: Calculate max profit for one transaction from left to right
        int minPrice = prices[0];  // Start with the first day's price
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); // Update the minimum price
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice); // Max profit so far
        }

        // Step 2: Calculate max profit for one transaction from right to left
        int maxPrice = prices[n - 1];  // Start with the last day's price
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]); // Update the maximum price
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]); // Max profit so far
        }

        // Step 3: Calculate maximum profit by combining both transactions
        maxProfit = 0;  // Initialize max profit
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]); // Max profit calculation
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Array of stock prices
        int[] prices1 = {20, 30, 45, 60, 75, 70};  // Prices for the days
        findMaxProfit(prices1);  // Call the method to calculate max profit
        System.out.println("Max Profit: " + maxProfit);

        // Test Case 2: Another set of stock prices
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80}; // Prices for the days
        findMaxProfit(prices2);  // Calculate max profit
        System.out.println("Max Profit: " + maxProfit); 
    }
}
