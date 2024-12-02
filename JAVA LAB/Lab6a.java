import java.util.Scanner;
public class Lab6a {
      public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of coins: ");
    int n = scanner.nextInt();

           int[] coins = new int[n];
        System.out.println("Enter the coin numbers:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
                System.out.print("Enter the needed sum: ");
                    int target = scanner.nextInt();

           CoinThread thread = new CoinThread(coins, target);
                   thread.start();

        try {
            thread.join();
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Thread was interrupted.");
        }
        System.out.println("Number of ways to make the sum: " + thread.result);
    }
}


class CoinThread extends Thread {
    int[] coins;
    int target;
    int result;

    CoinThread(int[] coins, int target) {
           this.coins = coins;
         this.target = target;
    }
    public void run() {
        int[] dp = new int[target + 1];
        dp[0] = 1; 

        for (int coin : coins) {
            for (int j = coin; j <= target; j++) {
                dp[j] += dp[j - coin];
            }
        }
result = dp[target];
    }
}
