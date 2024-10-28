import java.util.Scanner;

public class Lab2a {

    // Array to store input numbers
    static int[] numbers;

    // Method to find the K most frequent numbers in the array
    public static void findTopKFrequent(int K) {
        int n = numbers.length;

        // Find the maximum number to determine the frequency array size
        int maxNumber = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        // Create an array to store how often each number appears
        int[] frequency = new int[maxNumber + 1];
        for (int i = 0; i < n; i++) {
            frequency[numbers[i]]++;
        }

        // Find the top K frequent numbers with the priority condition
        System.out.println("Top " + K + " frequent numbers:");
        int count = 0;

        // Loop to find numbers with highest frequency, in descending order
        while (count < K) {
            int maxFreq = 0;
            int mostFrequent = -1;

            // Find the number with the highest frequency, and larger value in case of a tie
            for (int i = 0; i <= maxNumber; i++) {
                if (frequency[i] > maxFreq || (frequency[i] == maxFreq && i > mostFrequent)) {
                    maxFreq = frequency[i];
                    mostFrequent = i;
                }
            }

            // Print the number if it appears at least once
            if (mostFrequent != -1 && maxFreq > 0) {
                System.out.print(mostFrequent + " ");
                frequency[mostFrequent] = 0; // Mark as used
                count++;
            }
        }
        System.out.println();  // Print new line after top K numbers
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the number of elements in the array: ");
        int N = sc.nextInt();
        
        // Initialize the array
        numbers = new int[N];
        
        // Fill the array with user input
        System.out.println("Enter " + N + " numbers:");
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // Get the value of K from the user
        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        // Call the method to find and print the K most frequent numbers
        findTopKFrequent(K);
    }
}
