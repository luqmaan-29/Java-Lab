import java.util.Scanner;

public class lab5b {
public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
System.out.println("Enter the number of blocks:");
        int n = scanner.nextInt();
int[] blockHeights = new int[n];
System.out.println("Enter the heights of the blocks:");
for (int i = 0; i < n; i++) {
                        blockHeights[i] = scanner.nextInt();
}
int trappedWater = calculateTrappedWater(blockHeights);
System.out.println("Total trapped water: " + trappedWater + " units");
}

public static int calculateTrappedWater(int[] blockHeights) {
          int n = blockHeights.length;
if (n < 3) {
           return 0;
}
int[] leftMax = new int[n];
                                  int[] rightMax = new int[n];
leftMax[0] = blockHeights[0];
for (int i = 1; i < n; i++) {
leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
}
          rightMax[n - 1] = blockHeights[n - 1];
for (int i = n - 2; i >= 0; i--) {
                 rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
}
int totalWater = 0;
for (int i = 0; i < n; i++) {
                    totalWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
}
return totalWater;
}
}
