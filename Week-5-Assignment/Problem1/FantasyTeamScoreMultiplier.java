import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    static final double CAPTAIN_MULTIPLIER = 2.0;
    static final double VICE_CAPTAIN_MULTIPLIER = 1.5;

    public static void applyMultipliers(double[] playerScores,
                                        int captainIndex,
                                        int viceCaptainIndex) {

        playerScores[captainIndex] =
                playerScores[captainIndex] * CAPTAIN_MULTIPLIER;

        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * VICE_CAPTAIN_MULTIPLIER;
    }

    public static void main(String[] args) {

        double[] playerScores = {40, 55, 30, 62};

        int captainIndex = 1;
        int viceCaptainIndex = 3;

        applyMultipliers(playerScores, captainIndex, viceCaptainIndex);

        System.out.println(Arrays.toString(playerScores));
    }
}