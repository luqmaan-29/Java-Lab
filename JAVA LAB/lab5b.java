import java.util.Scanner;

public class lab5b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the number of blocks
        System.out.println("Enter the number of blocks:");
        int n = scanner.nextInt();

        // Ask the user to input the heights of the blocks
        int[] blockHeights = new int[n];
        System.out.println("Enter the heights of the blocks:");
        for (int i = 0; i < n; i++) {
            blockHeights[i] = scanner.nextInt();
        }

        // Calculate the trapped water
        int trappedWater = calculateTrappedWater(blockHeights);

        // Display the result
        System.out.println("Total trapped water: " + trappedWater + " units");
    }

    // Simplified method to calculate trapped water
    public static int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;

        // If there are fewer than 3 blocks, no water can be trapped
        if (n < 3) {
            return 0;
        }

        // Create arrays to store the maximum heights to the left and right
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill the leftMax array
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Fill the rightMax array
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        // Calculate the total trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return totalWater;
    }
}
