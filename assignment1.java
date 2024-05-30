package common;

public class Assignment1 {

    static final int N = 8;

    // Check if x, y are valid indices for an N*N chessboard
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // SolveKnightTourUtil is a recursive function to solve Knight Tour problem
    static boolean solveKnightsTourUtil(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (moveCount == N * N)
            return true;

        // Try all next moves from the current coordinate moveX, moveY
        for (k = 0; k < 8; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTourUtil(board, nextX, nextY, moveCount + 1, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtracking
            }
        }
        return false;
    }

    // This function solves the Knight Tour problem using Backtracking.
    // This function mainly uses solveKnightsTourUtil() to solve the problem.
    static boolean solveKnightsTour() {
        int[][] board = new int[N][N];

        // Initialization of the chessboard
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;

        // xMove[] and yMove[] define next move of Knight.
        // xMove[] is for next value of x coordinate
        // yMove[] is for next value of y coordinate
        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // Since the Knight is initially at the first block
        board[0][0] = 0;

        // Start from 0,0 and explore all tours using solveKnightsTourUtil()
        if (!solveKnightsTourUtil(board, 0, 0, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(board);

        return true;
    }

    // A utility function to print solution matrix board[N][N]
    static void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        solveKnightsTour();
    }
}
