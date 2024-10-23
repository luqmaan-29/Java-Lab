import java.util.Scanner;

public class Lab1a {
    private String ccNumber;  // Credit card number input from the user

    // Constructor to initialize the credit card number
    public Lab1a(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validateCard() {
        int length = ccNumber.length();

        // Check if the credit card number has 8 or 9 digits
        if (length < 8 || length > 9) {
            System.out.println("Invalid credit card number.");
            return; // If not, exit the validation process
        }

        // Step 1: Separate the last digit (check digit) from the number
        int lastDigit = Integer.parseInt(ccNumber.substring(length - 1));
        String remainingDigits = ccNumber.substring(0, length - 1);

        // Step 2: Reverse the remaining digits
        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        // Step 3: Double every second digit starting from the reversed list
        int sum = 0;
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));

            // Double the digits at odd positions (after reversing, these are the even ones in the original)
            if (i % 2 == 0) {
                digit *= 2;
                // If the result is greater than 9, sum the digits (e.g. 12 becomes 1 + 2)
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }
            sum += digit; // Add each digit to the total sum
        }

        // Step 4: Calculate the check digit from the sum
        int checkDigit = (10 - (sum % 10)) % 10;

        // Step 5: Check if the calculated check digit matches the actual last digit
        if (checkDigit == lastDigit) {
            System.out.println("Credit card is valid.");
        } else {
            System.out.println("Credit card is invalid.");
        }
    }

    public static void main(String[] args) {
        // Get user input for the credit card number
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number (8 or 9 digits): ");
        String ccNumber = scanner.nextLine();

        // Create an object of Lab1a and call the validation method
        Lab1a validator = new Lab1a(ccNumber);
        validator.validateCard();
    }
}
