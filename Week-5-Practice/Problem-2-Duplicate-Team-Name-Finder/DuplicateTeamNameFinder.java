import java.util.Scanner;

public class DuplicateTeamNameFinder {

    public static String findDuplicateTeam(
            String[] teamNames) {

        for (int firstIndex = 0;
             firstIndex < teamNames.length;
             firstIndex++) {

            for (int secondIndex = firstIndex + 1;
                 secondIndex < teamNames.length;
                 secondIndex++) {

                if (teamNames[firstIndex].equals(
                        teamNames[secondIndex])) {

                    return "Duplicate Found: "
                            + teamNames[firstIndex];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int numberOfTeams = scanner.nextInt();

        scanner.nextLine();

        String[] teamNames =
                new String[numberOfTeams];

        System.out.println("Enter team names:");

        for (int index = 0;
             index < numberOfTeams;
             index++) {

            teamNames[index] = scanner.nextLine();
        }

        String result =
                findDuplicateTeam(teamNames);

        System.out.println(result);

        scanner.close();
    }
}