public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        // Test case 1: Insert players and play the game
        game.insert("Talha");
        game.insert("Sharjeel");
        game.insert("Sahil");
        game.insert("Ikhlas");
        game.insert("Hashir");
        System.out.println("Initial state: " + game.toString());

        String winner = game.playGame();
        System.out.println("Winner: " + winner);

        // Test case 2: Insert a single player and play the game
        Game game2 = new Game();
        game2.insert("Lone Player");
        System.out.println("Initial state: " + game2.toString());

        winner = game2.playGame();
        System.out.println("Winner: " + winner);

        // Test case 3: Play the game with an empty list
        Game game3 = new Game();
        System.out.println("Initial state: " + game3.toString());

        winner = game3.playGame();
        System.out.println("Winner: " + winner);
    }
}
