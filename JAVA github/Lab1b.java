public class Lab1b {

    // Constructor
    public Lab1b() {
        // Nothing to initialize here
    }

    // Method to handle battle with a single word input
    public void battle(String word) {
        int leftScore = 0;
        int rightScore = 0;

        // Loop through each character of the word
        for (char c : word.toCharArray()) {
            // Add the scores based on left and right side letter strengths
            leftScore += getLeftStrength(c);
            rightScore += getRightStrength(c);
        }

        // Check who won
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Overloaded method to battle when we have two separate words
    public void battle(String leftWord, String rightWord) {
        int leftScore = 0;
        int rightScore = 0;

        // Calculate score for leftWord
        for (char c : leftWord.toCharArray()) {
            leftScore += getLeftStrength(c);
        }

        // Calculate score for rightWord
        for (char c : rightWord.toCharArray()) {
            rightScore += getRightStrength(c);
        }

        // Determine the winner
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Helper method to check strength of left-side letters
    private int getLeftStrength(char c) {
        switch (c) {
            case 'w':
                return 4;
            case 'p':
                return 3;
            case 'b':
                return 2;
            case 's':
                return 1;
            default:
                return 0;  // Not a left-side letter
        }
    }

    // Helper method to check strength of right-side letters
    private int getRightStrength(char c) {
        switch (c) {
            case 'm':
                return 4;
            case 'q':
                return 3;
            case 'd':
                return 2;
            case 'z':
                return 1;
            default:
                return 0;  // Not a right-side letter
        }
    }

    public static void main(String[] args) {
        Lab1b game = new Lab1b();

        // Test with single word input
        System.out.println("Test 1 (Word: 'z'):");
        game.battle("z");  // Right side should win

        // Test with a mix of left and right-side letters
        System.out.println("Test 2 (Word: 'zdqmwpbs'):");
        game.battle("zdqmwpbs");  // Should be a tie

        // Test where left side is stronger
        System.out.println("Test 3 (Word: 'wwwwwwz'):");
        game.battle("wwwwwwz");  // Left side should win

        // Test with two separate words for left and right
        System.out.println("Test 4 (Left Word: 'wbp', Right Word: 'mqdz'):");
        game.battle("wbp", "mqdz");  // Should result in a tie
    }
}
