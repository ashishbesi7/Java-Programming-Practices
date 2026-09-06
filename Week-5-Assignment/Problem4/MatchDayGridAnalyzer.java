public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {

        int totalRuns = 0;

        for (int runs : row) {
            totalRuns += runs;
        }

        return (double) totalRuns / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver,
                                         int threshold) {

        StringBuilder result = new StringBuilder();

        for (int matchIndex = 0;
             matchIndex < runsPerOver.length;
             matchIndex++) {

            double average = rowAverage(runsPerOver[matchIndex]);

            if (average >= threshold) {
                result.append("Match ")
                      .append(matchIndex)
                      .append(": Power Surge");
            } else {
                result.append("Match ")
                      .append(matchIndex)
                      .append(": Normal");
            }

            if (matchIndex < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        int threshold = 8;

        String result = classifyMatches(runsPerOver, threshold);

        System.out.println(result);
    }
}