public class DuplicatePlayerPickChecker {

    public static String findDuplicatePick(String[] playerNames) {

        for (int firstIndex = 0; firstIndex < playerNames.length; firstIndex++) {

            for (int secondIndex = firstIndex + 1;
                 secondIndex < playerNames.length;
                 secondIndex++) {

                if (playerNames[firstIndex].equals(playerNames[secondIndex])) {
                    return "Duplicate Found: " + playerNames[firstIndex];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        String[] playerNames = {
            "Kohli",
            "Bumrah",
            "Kohli",
            "Rohit"
        };

        String result = findDuplicatePick(playerNames);

        System.out.println(result);
    }
}