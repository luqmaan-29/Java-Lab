import java.util.ArrayList;

class AccessTimeComparison extends Thread {
    private int[] array;
    private ArrayList<Integer> arrayList;
    private int index;
    private long accessTime;

    public AccessTimeComparison(int[] array, ArrayList<Integer> arrayList, int index) {
        this.array = array;
        this.arrayList = arrayList;
        this.index = index;
    }

    @Override
    public void run() {
        if (array != null) {
            long startTime = System.nanoTime();
            int arrayValue = array[index];
            long endTime = System.nanoTime();
            accessTime = endTime - startTime;
            System.out.println("Array AccessTime: " + accessTime);
        } else if (arrayList != null) {
            long startTime = System.nanoTime();
            int arrayListValue = arrayList.get(index);
            long endTime = System.nanoTime();
            accessTime = endTime - startTime;
            System.out.println("ArrayList AccessTime: " + accessTime);
        }
    }

    public long getAccessTime() {
        return accessTime;
    }
}

class Test {
    public static void main(String[] args) {
        int[] array = new int[100];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            array[i] = i;
            arrayList.add(i);
        }

        int indexToAccess = 50;

        for (int iteration = 1; iteration <= 5; iteration++) {
            System.out.println("Iteration: " + iteration);

            AccessTimeComparison arrayThread = new AccessTimeComparison(array, null, indexToAccess);
            AccessTimeComparison arrayListThread = new AccessTimeComparison(null, arrayList, indexToAccess);

            arrayThread.start();
            arrayListThread.start();

            try {
                arrayThread.join();
                arrayListThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long arrayAccessTime = arrayThread.getAccessTime();
            long arrayListAccessTime = arrayListThread.getAccessTime();

            System.out.println("Array AccessTime: " + arrayAccessTime);
            System.out.println("ArrayList AccessTime: " + arrayListAccessTime);
            System.out.println("AccessTime Difference: " + (arrayAccessTime - arrayListAccessTime));
            System.out.println();

            // Add a time interval (2 seconds) between iterations
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}