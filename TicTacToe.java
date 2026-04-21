import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC3
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // UC4: Convert slot → row, col
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
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

        // UC2: Toss
        Random random = new Random();
        int toss = random.nextInt(2);

        int currentPlayer = (toss == 0) ? 1 : 2;
        System.out.println("Player " + currentPlayer + " starts");

        // UC3
        int slot = getUserInput();

        // UC4
        int[] position = getRowCol(slot);
        int row = position[0];
        int col = position[1];

        System.out.println("Mapped to -> Row: " + row + ", Col: " + col);
    }
}