package org.algos.RecursionORBacktracking.SudokuSolverAlgo;

//Sudoku Solver using Backtracking is a recursive algorithm that fills
//        empty cells by trying valid numbers and reverting
//        (backtracking) when a choice leads to an invalid state.

//           Algorithm Explanation
//
//        Find the first empty cell (value = 0)
//
//        Try digits 1 → 9 one by one
//
//        Check if placing a digit is safe (row, column, 3×3 box)
//
//        If safe → place the digit and recurse
//
//        If recursion fails → remove digit (backtrack)
//
//        If no empty cell left → Sudoku solved

import java.io.*;
import java.util.*;

class SudokuSolver {

    static int[][] g = {
            {5, 3, 0},
            {0, 7, 0},
            {0, 0, 0}
    };

    static boolean solve() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (g[r][c] == 0) {
                    for (int d = 1; d <= 9; d++) {
                        if (ok(r, c, d)) {
                            g[r][c] = d;
                            if (solve()) return true;
                            g[r][c] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    static boolean ok(int r, int c, int d) {
        for (int i = 0; i < 3; i++) {
            if (g[r][i] == d) return false;
            if (g[i][c] == d) return false;
        }
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (g[i][j] == d) return false;
            }
        }

        return true;
    }

    static void print() {
        for (int[] r : g) {
            for (int v : r) System.out.print(v + " ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        solve();
        print();
    }
}
