import java.util.Scanner;

class Program10_DeckOfCards {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeDeck(String[] deck, int players) {
        if (players <= 0 || deck.length % players != 0) return new String[0][0];

        int cardsPerPlayer = deck.length / players;
        String[][] playerCards = new String[players][cardsPerPlayer];

        for (int i = 0; i < deck.length; i++) {
            playerCards[i % players][i / players] = deck[i];
        }

        return playerCards;
    }

    public static void printPlayers(String[][] playerCards) {
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println("Player " + (i + 1) + ":");

            for (String card : playerCards[i]) {
                System.out.println(card);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int players = sc.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        String[][] playerCards = distributeDeck(deck, players);

        if (playerCards.length == 0) {
            System.out.println("Cards cannot be equally distributed among players");
        } else {
            printPlayers(playerCards);
        }
    }
}