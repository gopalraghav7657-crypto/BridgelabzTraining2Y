import java.util.Scanner;

class Program09_RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) return "rock";
        if (choice == 1) return "paper";
        return "scissors";
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";

        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int draws, int games) {
        double playerPercentage = games == 0 ? 0 : (playerWins * 100.0) / games;
        double computerPercentage = games == 0 ? 0 : (computerWins * 100.0) / games;

        return new String[][] {
            {"Player", String.valueOf(playerWins), String.format("%.2f", playerPercentage)},
            {"Computer", String.valueOf(computerWins), String.format("%.2f", computerPercentage)},
            {"Draw", String.valueOf(draws), String.format("%.2f", String.valueOf(draws * 100.0 / games).equals("NaN") ? 0 : draws * 100.0 / games)}
        };
    }

    public static void displayResults(String[][] games, String[][] stats) {
        System.out.printf("%-10s %-12s %-12s %-12s%n", "Game", "Player", "Computer", "Winner");
        for (String[] row : games) {
            System.out.printf("%-10s %-12s %-12s %-12s%n", row[0], row[1], row[2], row[3]);
        }

        System.out.println();
        System.out.printf("%-10s %-10s %-15s%n", "Player", stats[0][1], stats[0][2] + "%");
        System.out.printf("%-10s %-10s %-15s%n", "Computer", stats[1][1], stats[1][2] + "%");
        System.out.printf("%-10s %-10s %-15s%n", "Draw", stats[2][1], stats[2][2] + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfGames = sc.nextInt();
        String[][] games = new String[numberOfGames][4];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < numberOfGames; i++) {
            String player = sc.next().toLowerCase();
            String computer = getComputerChoice();
            String winner = findWinner(player, computer);

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            games[i][0] = String.valueOf(i + 1);
            games[i][1] = player;
            games[i][2] = computer;
            games[i][3] = winner;
        }

        String[][] stats = calculateStats(playerWins, computerWins, draws, numberOfGames);
        displayResults(games, stats);
    }
}