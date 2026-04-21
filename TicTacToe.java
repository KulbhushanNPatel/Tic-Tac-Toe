import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC3: Method to get user input
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1: Initialize board
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
        int toss = random.nextInt(2);

        char player1Symbol, player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            player1Symbol = 'X';
            player2Symbol = 'O';
            currentPlayer = 1;
            System.out.println("Player 1 starts and is 'X'");
        } else {
            player1Symbol = 'O';
            player2Symbol = 'X';
            currentPlayer = 2;
            System.out.println("Player 2 starts and is 'X'");
        }

        // UC3: Take input
        int slot = getUserInput();
        System.out.println("You selected slot: " + slot);
    }
}