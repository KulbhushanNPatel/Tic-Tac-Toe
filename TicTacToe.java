import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    // UC3
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // UC6
    public static void updateBoard(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Print board
    public static void printBoard(char[][] board) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // UC7
    public static void computerMove(char[][] board, char computerSymbol) {

        Random random = new Random();

        while (true) {

            int slot = random.nextInt(9) + 1;

            int[] pos = getRowCol(slot);

            int row = pos[0];
            int col = pos[1];

            if (isValidMove(board, row, col)) {

                updateBoard(board, row, col, computerSymbol);

                System.out.println("Computer selected slot: " + slot);

                break;
            }
        }
    }

    // UC8: Check draw
    public static boolean isBoardFull(char[][] board) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        char humanSymbol = 'X';
        char computerSymbol = 'O';

        boolean humanTurn = true;
        boolean gameRunning = true;

        System.out.println("Initial Board:");
        printBoard(board);

        // UC8 Game Loop
        while (gameRunning) {

            if (humanTurn) {

                int slot = getUserInput();

                int[] pos = getRowCol(slot);

                int row = pos[0];
                int col = pos[1];

                if (isValidMove(board, row, col)) {

                    updateBoard(board, row, col, humanSymbol);

                    System.out.println("Human Move:");
                    printBoard(board);

                    humanTurn = false;

                } else {

                    System.out.println("Invalid move ");
                }

            } else {

                computerMove(board, computerSymbol);

                System.out.println("Computer Move:");
                printBoard(board);

                humanTurn = true;
            }

            // Stop if board full
            if (isBoardFull(board)) {

                System.out.println("Game Draw!");

                gameRunning = false;
            }
        }
    }
}