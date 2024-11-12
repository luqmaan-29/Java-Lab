abstract class Robber {

    // Default method to print machine learning message
    public void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }

    // Abstract methods
    public abstract void RobbingClass();
    public abstract int RowHouses(int[] money);
    public abstract int RoundHouses(int[] cash);
    public abstract int SquareHouse(int[] sqHouse);
    public abstract int MultiHouseBuilding(int[]... bldg); 
}

class JAVAProfessionalRobber extends Robber {

    // Printing message for RobbingClass
    @Override
    public void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    // Helper for RoundHouses
    private int simpleRob(int[] arr, int start, int stop) {
        int robA = 0, robB = 0;
        for (int i = start; i <= stop; i++) {
            int tmp = robB;
            robB = Math.max(robA + arr[i], robB);
            robA = tmp;
        }
        return robB;
    }

    // Max money in row houses, no adjecent
    @Override
    public int RowHouses(int[] row) {
        int rob1 = 0, rob2 = 0;
        for (int r : row) {
            int temp = rob2;
            rob2 = Math.max(rob1 + r, rob2);
            rob1 = temp;
        }
        return rob2;
    }

    // Max money round houses with adjecent start end
    @Override
    public int RoundHouses(int[] round) {
        if (round.length == 1) return round[0];
        return Math.max(simpleRob(round, 0, round.length - 2), simpleRob(round, 1, round.length - 1));
    }

    // Calls RowHouses for square house
    @Override
    public int SquareHouse(int[] square) {
        return RowHouses(square);
    }

    // MultiHouseBuilding sums each type
    @Override
    public int MultiHouseBuilding(int[]... build) {
        int total = 0;
        for (int[] bld : build) {
            total += RowHouses(bld);
        }
        return total;
    }
}

public class Lab4 {
    public static void main(String[] args) {
        JAVAProfessionalRobber robbr = new JAVAProfessionalRobber();

        // Test cases
        robbr.RobbingClass();
        robbr.MachineLearning();
        
        System.out.println("RowHouses([1,2,3,0]) -> " + robbr.RowHouses(new int[]{1, 2, 3, 0}));
        System.out.println("RoundHouses([1,2,3,4]) -> " + robbr.RoundHouses(new int[]{1, 2, 3, 4}));
        System.out.println("SquareHouse([5,10,2,7]) -> " + robbr.SquareHouse(new int[]{5, 10, 2, 7}));
        System.out.println("MultiHouseBuilding([5,3,8,2],[10,12,7,6],[4,9,11,5],[8,6,3,7]) -> " +
                robbr.MultiHouseBuilding(new int[]{5, 3, 8, 2}, new int[]{10, 12, 7, 6}, 
                                         new int[]{4, 9, 11, 5}, new int[]{8, 6, 3, 7}));
    }
}
