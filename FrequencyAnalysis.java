import java.util.Scanner;

public class FrequencyAnalysis {
    // Static variable to hold the array of numbers
    static int[] numbers;

    // Static method to find the K numbers with the highest occurrences
    public static void findTopKFrequent(int K) {
        int n = numbers.length;
        
        // Step 1: Find the maximum number in the array (to set frequency array size)
        int maxNumber = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        // Step 2: Create a frequency array to count occurrences of each number
        int[] frequency = new int[maxNumber + 1];
        for (int i = 0; i < n; i++) {
            frequency[numbers[i]]++;
        }

        // Step 3: Sort numbers by frequency and by value manually
        int[][] numFreq = new int[maxNumber + 1][2]; // [number, frequency]
        for (int i = 0; i <= maxNumber; i++) {
            numFreq[i][0] = i;
            numFreq[i][1] = frequency[i];
        }

        // Sort numFreq array by frequency (descending), and then by number (descending)
        for (int i = 0; i < numFreq.length; i++) {
            for (int j = i + 1; j < numFreq.length; j++) {
                if (numFreq[i][1] < numFreq[j][1] || 
                    (numFreq[i][1] == numFreq[j][1] && numFreq[i][0] < numFreq[j][0])) {
                    // Swap the numbers
                    int[] temp = numFreq[i];
                    numFreq[i] = numFreq[j];
                    numFreq[j] = temp;
                }
            }
        }

        // Step 4: Print the top K frequent numbers
        System.out.println("Top " + K + " frequent numbers:");
        int count = 0;
        for (int i = 0; i < numFreq.length && count < K; i++) {
            if (numFreq[i][1] > 0) { // Only print numbers that appear in the array
                System.out.print(numFreq[i][0] + " ");
                count++;
            }
        }
        System.out.println(); // for a new line
    }

    public static void main(String[] args) {
        // Input from user
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
        
        findTopKFrequent(K); // Call the method to find the top K frequent numbers
    }
}
