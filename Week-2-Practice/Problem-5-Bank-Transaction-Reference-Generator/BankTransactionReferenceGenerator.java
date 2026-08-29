import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    public static String normalizeReference(String raw) {

        String trimmedReference = raw.trim();

        if (trimmedReference.length() < 3) {
            return trimmedReference.toUpperCase();
        }

        String bankCode =
                trimmedReference.substring(0, 3).toUpperCase();

        String remainingPart =
                trimmedReference.substring(3);

        return bankCode + remainingPart;
    }

    public static String validateAndFormat(
            String reference) {

        final int REQUIRED_LENGTH = 14;
        final int BANK_CODE_LENGTH = 3;

        if (reference.length() != REQUIRED_LENGTH) {

            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < BANK_CODE_LENGTH; i++) {

            if (!Character.isLetter(reference.charAt(i))) {

                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = BANK_CODE_LENGTH;
             i < reference.length();
             i++) {

            if (!Character.isDigit(reference.charAt(i))) {

                return "Invalid: reference body must contain digits";
            }
        }

        String bankCode =
                reference.substring(0, 3);

        String date =
                reference.substring(3, 9);

        String sequence =
                reference.substring(9, 14);

        StringBuilder formattedReference =
                new StringBuilder();

        formattedReference.append("[");
        formattedReference.append(bankCode);
        formattedReference.append("] DATE: ");

        formattedReference.append(date.substring(0, 2));
        formattedReference.append("/");
        formattedReference.append(date.substring(2, 4));
        formattedReference.append("/");
        formattedReference.append(date.substring(4, 6));

        formattedReference.append(" | SEQ: ");
        formattedReference.append(sequence);

        return formattedReference.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Enter transaction reference: "
        );

        String rawReference =
                scanner.nextLine();

        String normalizedReference =
                normalizeReference(rawReference);

        String result =
                validateAndFormat(normalizedReference);

        System.out.println(result);

        scanner.close();
    }
}