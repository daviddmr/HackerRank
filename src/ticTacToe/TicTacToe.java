package ticTacToe;

import java.util.Arrays;

class TicTacToe {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);

        ticTacToe.selectField(2, 0, 1);
        ticTacToe.selectField(1, 1, 1);
        ticTacToe.selectField(0, 2, 1);
    }

    private int[][] board;
    private int boardSize;

    private TicTacToe(int boardSize) {
        this.boardSize = boardSize;
        board = new int[boardSize][boardSize];
        fillBoard();
        printBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], 0);
        }
    }

    private void printBoard() {

        System.out.println("---------");

        for (int i = 0; i < boardSize; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        System.out.println("---------\n");
    }

    private void selectField(int x, int y, int player) {
        if (x >= boardSize || y >= boardSize) {
            return;
        }

        if (board[x][y] == 0) {
            board[x][y] = player;

            printBoard();

            if (checkIfPlayerWon(x, y, player)) {
                System.out.println("Player " + player + " won!");
            }
        }
    }

    private boolean checkIfPlayerWon(int x, int y, int player) {
        int row = 0;
        int col = 0;
        int diag = 0;
        int rDiag = 0;

        for (int i = 0; i < boardSize; i++) {
            if (board[x][i] == player) row++;
            if (board[i][y] == player) col++;
            if (board[i][i] == player) diag++;
            if (board[boardSize - i - 1][i] == player) rDiag++;

            if (row == boardSize || col == boardSize || diag == boardSize || rDiag == boardSize) {
                return true;
            }
        }

        return false;
    }
}
