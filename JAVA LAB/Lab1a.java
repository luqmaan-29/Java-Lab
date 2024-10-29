import java.util.Scanner;

public class Lab1a {
    private String ccNumber;

    public Lab1a(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void validateCard() {
        int length = ccNumber.length();

        if (length < 8 || length > 9) {
            System.out.println("Invalid credit card number.");
            return;
        }

        int lastDigit = Integer.parseInt(ccNumber.substring(length - 1));
        String remainingDigits = ccNumber.substring(0, length - 1);

        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        int sum = 0;
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = Character.getNumericValue(reversedDigits.charAt(i));

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }
            sum += digit;
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        if (checkDigit == lastDigit) {
            System.out.println("Credit card is valid.");
        } else {
            System.out.println("Credit card is invalid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number (8 or 9 digits): ");
        String ccNumber = scanner.nextLine();

        Lab1a validator = new Lab1a(ccNumber);
        validator.validateCard();
    }
}
