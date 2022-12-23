package ru.vsu.cs.course1;

import static ru.vsu.cs.course1.Different.*;

public class DCT {
    public static final double[][] DCTmatrix = DCTmatrix(8);

    public static int[][] solve(int[][] matrix) {
        int[][] result = copyOfMatrix(matrix);
        return toInt(prouz(prouz(DCTmatrix, normalization(result)), swap(DCTmatrix)));
    }

    public static double[][] DCTmatrix(int n) {
        double[][] result = new double[n][n];
        for (int j = 0; j < n; j++) {
            result[0][j] = ceilToMil(1 / Math.sqrt(n));
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = ceilToMil(ceilToSot(2 / Math.sqrt(n)) * Math.cos(ceilToSot((2 * j + 1) * i * Math.PI / 2 * n)));
            }
        }
        return result;
    }

    public static int[][] normalization(int[][] matrix) {
        int[][] result = copyOfMatrix(matrix);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = result[i][j] - 128;
            }
        }
        return result;
    }
}
