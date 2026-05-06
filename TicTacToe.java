import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC3
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
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

        if (board[row][col] != '-') {
            return false;
        }

        return true;
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

    // UC7: Computer move
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

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1 Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Initial Board:");
        printBoard(board);

        // UC2 Toss
        Random random = new Random();
        int toss = random.nextInt(2);

        int currentPlayer = (toss == 0) ? 1 : 2;

        char humanSymbol = 'X';
        char computerSymbol = 'O';

        System.out.println("Player " + currentPlayer + " starts");

        // Human move
        int slot = getUserInput();

        int[] pos = getRowCol(slot);
        int row = pos[0];
        int col = pos[1];

        if (isValidMove(board, row, col)) {

            updateBoard(board, row, col, humanSymbol);

            System.out.println("Board after Human move:");
            printBoard(board);

        } else {
            System.out.println("Invalid move ");
        }

        // UC7 Computer move
        computerMove(board, computerSymbol);

        System.out.println("Board after Computer move:");
        printBoard(board);
    }
}