import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(
            String name,
            double cgpa,
            int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {

        final double DIRECT_CGPA_THRESHOLD = 7.5;

        return cgpa >= DIRECT_CGPA_THRESHOLD;
    }

    public static boolean isEligible(
            double cgpa,
            int codingScore) {

        final double BORDERLINE_CGPA_MIN = 6.5;
        final double BORDERLINE_CGPA_MAX = 7.4;
        final int CODING_SCORE_THRESHOLD = 60;

        return cgpa >= BORDERLINE_CGPA_MIN
                && cgpa <= BORDERLINE_CGPA_MAX
                && codingScore >= CODING_SCORE_THRESHOLD;
    }

    public double getCompositeScore() {

        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    public String getName() {
        return name;
    }

    public static String shortlistAndRank(
            Candidate[] candidates) {

        int eligibleCount = 0;

        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(
                            candidate.cgpa,
                            candidate.codingScore)) {

                eligibleCount++;
            }
        }

        Candidate[] shortlisted =
                new Candidate[eligibleCount];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(
                            candidate.cgpa,
                            candidate.codingScore)) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder result =
                new StringBuilder();

        for (int rank = 0;
             rank < shortlisted.length;
             rank++) {

            Candidate candidate =
                    shortlisted[rank];

            result.append(rank + 1)
                  .append(". ")
                  .append(candidate.getName())
                  .append(" (")
                  .append(String.format(
                          "%.1f",
                          candidate.getCompositeScore()))
                  .append(")");

            if (rank < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}

public class PlacementShortlistingRanking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int numberOfCandidates = scanner.nextInt();

        scanner.nextLine();

        Candidate[] candidates =
                new Candidate[numberOfCandidates];

        for (int index = 0;
             index < numberOfCandidates;
             index++) {

            System.out.println(
                    "\nCandidate " + (index + 1)
            );

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = scanner.nextInt();

            scanner.nextLine();

            candidates[index] =
                    new Candidate(
                            name,
                            cgpa,
                            codingScore
                    );
        }

        String result =
                Candidate.shortlistAndRank(candidates);

        System.out.println("\nShortlisted Candidates:");
        System.out.println(result);

        scanner.close();
    }
}