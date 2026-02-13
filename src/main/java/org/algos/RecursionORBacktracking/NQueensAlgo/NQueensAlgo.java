package org.algos.RecursionORBacktracking.NQueensAlgo;

//N-Queen Problem: Place N queens on an N×N chessboard such that no
//        two queens attack each other.
//        Queens must not share the same row, column, or diagonal.

//              Algorithm Explanation
//
//        Place queens row by row, starting from row 0
//
//        For the current row:
//
//        Try placing a queen in every column
//
//        Before placing, check safety
//
//        Safe means:
//
//        No queen in the same column
//
//        No queen in the left diagonal
//
//        No queen in the right diagonal
//
//        If safe:
//
//        Place the queen
//
//        Recursively move to the next row
//
//        If no column works:
//
//        Backtrack → remove the previous queen
//
//        When row == N → one valid solution found

import java.io.*;
import java.util.*;

class NQueen {

    static int N = 4;
    static int[][] board = new int[N][N];

    public static void main(String[] args) {
        solve(0);
    }

    static void solve(int row) {
        if (row == N) {
            printBoard();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                solve(row + 1);
                board[row][col] = 0;
            }
        }
    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

        System.out.println();
    }
}
