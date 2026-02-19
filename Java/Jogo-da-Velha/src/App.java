import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}

class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void play() {
        boolean playing = true;
        while (playing) {
            printBoard();
            playerMove();
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                playing = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                playing = false;
            } else {
                togglePlayer();
            }
        }
    }

    private void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    private void playerMove() {
        int row = -1, col = -1;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            if (parts.length >= 2) {
                try {
                    row = Integer.parseInt(parts[0]) - 1;
                    col = Integer.parseInt(parts[1]) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input; please enter numbers.");
                    continue;
                }
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("Cell already taken, choose another.");
                    }
                } else {
                    System.out.println("Coordinates out of range.");
                }
            } else {
                System.out.println("Please enter two numbers separated by space.");
            }
        }
    }

    private boolean checkWin() {
        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        // diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
