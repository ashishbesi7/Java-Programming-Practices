import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(
            String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(Random random) {

        String[] moves = {"Rock", "Paper", "Scissors"};

        int randomIndex = random.nextInt(moves.length);

        return moves[randomIndex];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfRounds = 5;

        String[] playerMoves = new String[numberOfRounds];
        String[] computerMoves = new String[numberOfRounds];
        String[] results = new String[numberOfRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 0; round < numberOfRounds; round++) {

            System.out.print(
                    "Enter your move for Round "
                    + (round + 1)
                    + " (Rock/Paper/Scissors): "
            );

            String playerMove = scanner.nextLine().trim();

            String computerMove =
                    generateComputerMove(random);

            String result =
                    playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(
                    "Player: " + playerMove
                    + " | Computer: " + computerMove
                    + " | Result: " + result
            );
        }

        double winPercentage =
                (wins * 100.0) / numberOfRounds;

        System.out.println("\nFinal Summary");
        System.out.println("---------------------------------------------");
        System.out.printf(
                "%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move",
                "Computer Move", "Result"
        );
        System.out.println("---------------------------------------------");

        for (int round = 0; round < numberOfRounds; round++) {

            System.out.printf(
                    "%-8d %-15s %-15s %-15s%n",
                    round + 1,
                    playerMoves[round],
                    computerMoves[round],
                    results[round]
            );
        }

        System.out.println("---------------------------------------------");

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf(
                "Win Percentage: %.2f%%%n",
                winPercentage
        );

        scanner.close();
    }
}