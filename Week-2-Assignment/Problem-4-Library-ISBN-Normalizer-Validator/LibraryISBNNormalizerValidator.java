public class LibraryISBNNormalizerValidator {

    public static String normalizeCode(String raw) {

        String trimmedCode = raw.trim();

        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }

        String publisherCode =
                trimmedCode.substring(0, 3).toUpperCase();

        String remainingCode =
                trimmedCode.substring(3);

        return publisherCode + remainingCode;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7);

        StringBuilder formattedResult = new StringBuilder();

        formattedResult.append("[")
                       .append(publisherCode)
                       .append("] YEAR: ")
                       .append(year)
                       .append(" | CATALOG: ")
                       .append(catalogNumber);

        return formattedResult.toString();
    }

    public static void main(String[] args) {

        String rawCode = " pen2026004251 ";

        String normalizedCode = normalizeCode(rawCode);

        String result = validateAndFormat(normalizedCode);

        System.out.println(result);
    }
}