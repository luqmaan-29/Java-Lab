public class Daa {

    public static void main(String[] args) {
        int[] bestCase = {10, 20, 30, 40, 50, 60, 70};        // Already sorted array (Best Case)
        int[] averageCase = {64, 34, 25, 12, 22, 11, 90};     // Random array (Average Case)
        int[] worstCase = {90, 80, 70, 60, 50, 40, 30};       // Reverse sorted array (Worst Case)

        System.out.println("Bubble Sort:");
        measureSortingComplexity(bestCase.clone(), "Bubble Sort", "Best Case");
        measureSortingComplexity(averageCase.clone(), "Bubble Sort", "Average Case");
        measureSortingComplexity(worstCase.clone(), "Bubble Sort", "Worst Case");

        System.out.println("\nInsertion Sort:");
        measureSortingComplexity(bestCase.clone(), "Insertion Sort", "Best Case");
        measureSortingComplexity(averageCase.clone(), "Insertion Sort", "Average Case");
        measureSortingComplexity(worstCase.clone(), "Insertion Sort", "Worst Case");

        System.out.println("\nQuick Sort:");
        measureSortingComplexity(bestCase.clone(), "Quick Sort", "Best Case");
        measureSortingComplexity(averageCase.clone(), "Quick Sort", "Average Case");
        measureSortingComplexity(worstCase.clone(), "Quick Sort", "Worst Case");
    }

    public static void measureSortingComplexity(int[] arr, String algorithm, String caseType) {
        long startTime = System.nanoTime();

        // Perform the sorting based on the algorithm specified
        switch (algorithm) {
            case "Bubble Sort":
                bubbleSort(arr);
                break;
            case "Insertion Sort":
                insertionSort(arr);
                break;
            case "Quick Sort":
                quickSort(arr, 0, arr.length - 1);
                break;
            default:
                System.out.println("Unknown algorithm specified");
                return;
        }

        long endTime = System.nanoTime();
        double timeTakenSeconds = (endTime - startTime) / 1_000_000_000.0; // Convert nanoseconds to seconds

        // Print results
        System.out.printf("%s - %s: Time Taken = %.9f seconds\n", algorithm, caseType, timeTakenSeconds);
    }

    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort Implementation
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
