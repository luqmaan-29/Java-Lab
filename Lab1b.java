public class Lab1b {

    // Constructor with default settings (no need to store strengths in a map)
    public Lab1b() {
        // No initialization required as we don't store the strengths in a map
    }

    // Method to battle with a single word input (both sides combined)
    public void battle(String word) {
        int leftScore = 0;
        int rightScore = 0;

        // Loop through each character in the input word
        for (char c : word.toCharArray()) {
            // Determine the strength of each letter using helper methods
            leftScore += getLeftStrength(c);
            rightScore += getRightStrength(c);
        }

        // Determine who wins
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Overloaded method to battle with separate left and right words
    public void battle(String leftWord, String rightWord) {
        int leftScore = 0;
        int rightScore = 0;

        // Loop through each character in the left word
        for (char c : leftWord.toCharArray()) {
            leftScore += getLeftStrength(c);
        }

        // Loop through each character in the right word
        for (char c : rightWord.toCharArray()) {
            rightScore += getRightStrength(c);
        }

        // Determine who wins
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    // Helper method to get the strength of left-side letters
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

    // Helper method to get the strength of right-side letters
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
        // Test cases with default strengths
        Lab1b game = new Lab1b();

        // Test case 1: Single word
        System.out.println("Test 1 (Word: 'z'):");
        game.battle("z");  // Right side wins!

        // Test case 2: Single word with mixed letters
        System.out.println("Test 2 (Word: 'zdqmwpbs'):");
        game.battle("zdqmwpbs");  // Let's fight again!

        // Test case 3: Single word, left side strong
        System.out.println("Test 3 (Word: 'wwwwwwz'):");
        game.battle("wwwwwwz");  // Left side wins!

        // Test case 4: Separate words
        System.out.println("Test 4 (Left Word: 'wbp', Right Word: 'mqdz'):");
        game.battle("wbp", "mqdz");  // Let's fight again!
    }
}
