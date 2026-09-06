import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player() {
            this("Unknown", 0, 0.0, false);
        }

        public Player(String name) {
            this(name, 0, 0.0, false);
        }

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        public static boolean isDraftable(int matchesPlayed,
                                          boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        private double getFantasyPoints() {
            return matchesPlayed + battingAverage;
        }

        @Override
        public int compareTo(Player other) {

            if (this.getFantasyPoints() < other.getFantasyPoints()) {
                return 1;
            }

            if (this.getFantasyPoints() > other.getFantasyPoints()) {
                return -1;
            }

            return 0;
        }

        public String getName() {
            return name;
        }
    }

    public static String draftAndRank(Player[] players) {

        Player[] draftablePlayers = new Player[players.length];

        int draftableCount = 0;

        for (Player player : players) {

            boolean draftable;

            if (Player.isDraftable(player.matchesPlayed)) {
                draftable = true;
            } else {
                draftable = Player.isDraftable(
                        player.matchesPlayed,
                        player.injured
                );
            }

            if (draftable) {
                draftablePlayers[draftableCount] = player;
                draftableCount++;
            }
        }

        Player[] shortlistedPlayers =
                Arrays.copyOf(draftablePlayers, draftableCount);

        Arrays.sort(shortlistedPlayers);

        StringBuilder result = new StringBuilder();

        for (int index = 0;
             index < shortlistedPlayers.length;
             index++) {

            result.append(index + 1)
                  .append(". ")
                  .append(shortlistedPlayers[index].getName());

            if (index < shortlistedPlayers.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);

        System.out.println(result);
    }
}