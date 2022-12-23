package ru.vsu.cs.course1;

import static ru.vsu.cs.course1.Different.*;

public class Quantization {
    public static final int[][] quantizationMatrix = toInt(quantizationMatrix(8, 1));

    public static int[][] solve(int[][] matrix, int[][] quantizationMatrix) {
        int[][] result = copyOfMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = (int) Math.round(result[i][j] / quantizationMatrix[i][j]);
            }
        }
        return result;
    }

    public static double[][] quantizationMatrix(int n, double q) {
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 1 + ceilToSot((1 + i + j) * q);
            }
        }
        return result;
    }
}
