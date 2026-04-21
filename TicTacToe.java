import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Print board
        System.out.println("Initial Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // UC2: Random toss
        Random random = new Random();
        int toss = random.nextInt(2); // 0 or 1

        char player1Symbol, player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = 1;
            System.out.println("Player 1 starts and is assigned 'X'");
        } else {
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = 2;
            System.out.println("Player 2 starts and is assigned 'X'");
        }

        // Store state (just printing for now)
        System.out.println("Current Player: Player " + currentPlayer);
    }
}