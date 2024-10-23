import java.util.Scanner;

public class Lab2a {

    // Array to store input numbers
    static int[] numbers;

    // Method to find the K most frequent numbers in the array
    public static void findTopKFrequent(int K) {
        int n = numbers.length;
        
        // Find the maximum number in the array to define frequency array size
        int maxNumber = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];  // Update max number
            }
        }

        // Create a frequency array to count how often each number appears
        int[] frequency = new int[maxNumber + 1];
        for (int i = 0; i < n; i++) {
            frequency[numbers[i]]++;  // Count occurrences
        }

        // Create an array to store both the number and its frequency
        int[][] numFreq = new int[maxNumber + 1][2]; // [number, frequency]
        for (int i = 0; i <= maxNumber; i++) {
            numFreq[i][0] = i;        // Store number
            numFreq[i][1] = frequency[i];  // Store its frequency
        }

        // Sort numbers based on frequency (and by number if frequencies match)
        for (int i = 0; i < numFreq.length; i++) {
            for (int j = i + 1; j < numFreq.length; j++) {
                // Sort by frequency first, then by number value
                if (numFreq[i][1] < numFreq[j][1] || 
                    (numFreq[i][1] == numFreq[j][1] && numFreq[i][0] < numFreq[j][0])) {
                    // Swap values
                    int[] temp = numFreq[i];
                    numFreq[i] = numFreq[j];
                    numFreq[j] = temp;
                }
            }
        }

        // Print the top K frequent numbers
        System.out.println("Top " + K + " frequent numbers:");
        int count = 0;
        for (int i = 0; i < numFreq.length && count < K; i++) {
            if (numFreq[i][1] > 0) {  // Only print numbers that actually appear
                System.out.print(numFreq[i][0] + " ");
                count++;  // Increment the count for top K
            }
        }
        System.out.println();  // Add a new line after printing
    }

    public static void main(String[] args) {
        // Input handling
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int N = sc.nextInt();  // Get the size of the array
        
        numbers = new int[N];
        System.out.println("Enter " + N + " numbers:");
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();  // Fill the array with user input
        }
        
        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();  // Get the value of K from user
        
        findTopKFrequent(K);  // Call the method to find and print the K most frequent numbers
    }
}
