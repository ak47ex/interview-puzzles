package com.suenara.interviewPuzzles.arrays;

import java.util.LinkedList;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 */
public class ZeroWay {

    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] matrix = new int[n][m];
        int key = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                key++;
                matrix[i][j] = Math.random() > 0.9 ? 0 : key;
                System.out.print(String.format("%3d", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();

        zeroWay(matrix);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(String.format("%3d", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void zeroWay(int[][] matrix) {
        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] != 0) continue;

                rows.add(i);
                cols.add(j);
            }
        }

        for (int i : rows) {
            for (int j  = 0; j < matrix.length; ++j) {
                matrix[i][j] = 0;
            }
        }

        for (int j : cols) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[i][j] = 0;
            }
        }
    }

}
