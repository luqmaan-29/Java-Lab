import java.util.Scanner;

public class CreditCardValidator {
    private String ccNumber;  // Credit card number

    // Constructor to initialize the credit card number
    public CreditCardValidator(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validateCard() {
        int length = ccNumber.length();

        // Rule 1: Check if the credit card number has a valid length (8 or 9 digits)
        if (length < 8 || length > 9) {
            System.out.println("Invalid credit card number.");
            return;
        }

        // Step a: Remove the last digit and store it separately
        int lastDigit = Integer.parseInt(ccNumber.substring(length - 1));
        String remainingDigits = ccNumber.substring(0, length - 1);

        // Step b: Reverse the remaining digits
        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        // Step c: Double the digits in odd-numbered positions after reversing
        int sum = 0;
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));

            // Double the digits at odd positions (1st, 3rd, 5th, etc.)
            if (i % 2 == 0) {
                digit *= 2;
                // If the result is two digits, sum the digits
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }
            sum += digit;
        }

        // Step e: Subtract the sum mod 10 from 10 to get the check digit
        int checkDigit = (10 - (sum % 10)) % 10;

        // Step f: Compare checkDigit with the last digit from step a
        if (checkDigit == lastDigit) {
            System.out.println("Credit card is valid.");
        } else {
            System.out.println("Credit card is invalid.");
        }
    }

    public static void main(String[] args) {
        // Reading the credit card number from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number (8 or 9 digits): ");
        String ccNumber = scanner.nextLine();

        // Create an instance of CreditCardValidator and validate the card
        CreditCardValidator validator = new CreditCardValidator(ccNumber);
        validator.validateCard();
    }
}
