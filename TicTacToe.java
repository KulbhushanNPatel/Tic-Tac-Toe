import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    // Get user input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // Convert slot to row and column
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // Update board
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

    // Computer move
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

    // Check if board is full
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

    // Check win
    public static boolean checkWin(char[][] board, char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == symbol &&
                    board[i][1] == symbol &&
                    board[i][2] == symbol) {

                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {

            if (board[0][j] == symbol &&
                    board[1][j] == symbol &&
                    board[2][j] == symbol) {

                return true;
            }
        }

        // Main diagonal
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol) {

            return true;
        }

        // Opposite diagonal
        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol) {

            return true;
        }

        return false;
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

        // Game loop
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

                    // Check human win
                    if (checkWin(board, humanSymbol)) {

                        System.out.println("Human Player Wins!");
                        gameRunning = false;

                    } else if (isBoardFull(board)) {

                        System.out.println("Game Draw!");
                        gameRunning = false;

                    } else {

                        humanTurn = false;
                    }

                } else {

                    System.out.println("Invalid move ");
                }

            } else {

                computerMove(board, computerSymbol);

                System.out.println("Computer Move:");
                printBoard(board);

                // Check computer win
                if (checkWin(board, computerSymbol)) {

                    System.out.println("Computer Wins!");
                    gameRunning = false;

                } else if (isBoardFull(board)) {

                    System.out.println("Game Draw!");
                    gameRunning = false;

                } else {

                    humanTurn = true;
                }
            }
        }
    }
}