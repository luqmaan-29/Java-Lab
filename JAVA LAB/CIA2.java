import java.util.Scanner;
  interface PairCounter {
      int count(int[] numbers, int sum);
}

class SimplePairCounter implements PairCounter {
public int count(int[] numbers, int sum) {
 int pairCount = 0;
        for (int i = 0; i < numbers.length; i++) {
     for (int j = i + 1; j < numbers.length; j++) {


    if (numbers[i] + numbers[j] == sum) {
pairCount++;
}
}
}
 return pairCount;
}
}
public class CIA2 {
           public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
      System.out.print("Enter the number of elements: ");
            int size = in.nextInt();

          int[] nums = new int[size];
           System.out.println("Enter the elements:");
         for (int i = 0; i < size; i++)
          {
 nums[i] = in.nextInt();
}
     System.out.print("Enter the target: ");
          int targetSum = in.nextInt();
      PairCounter counter = new SimplePairCounter();
System.out.println("The number of pairs are: " + counter.count(nums, targetSum));
 
}
}
