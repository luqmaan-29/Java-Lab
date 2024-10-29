import java.util.Scanner;

public class Lab2a {

    static int[] numbers;

    public static void findTopKFrequent(int K) {
        int n = numbers.length;

        // Find the maximum number in the array
        int maxNumber = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        // Create an array to store the frequency of each number
        int[] frequency = new int[maxNumber + 1];
        for (int i = 0; i < n; i++) {
            frequency[numbers[i]]++;
        }

        System.out.println("Top " + K + " frequent numbers:");
        int count = 0;

        // Find the K most frequent numbers
        while (count < K) {
            int maxFreq = 0;
            int mostFrequent = -1;

            // Find the number with the highest frequency and largest value in case of ties
            for (int i = 0; i <= maxNumber; i++) {
                if (frequency[i] > maxFreq || (frequency[i] == maxFreq && i > mostFrequent)) {
                    maxFreq = frequency[i];
                    mostFrequent = i;
                }
            }

            // Print the most frequent number and mark it as used
            if (mostFrequent != -1 && maxFreq > 0) {
                System.out.print(mostFrequent + " ");
                frequency[mostFrequent] = 0;
                count++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int N = sc.nextInt();

        numbers = new int[N];

        System.out.println("Enter " + N + " numbers:");
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        findTopKFrequent(K);
    }
}
