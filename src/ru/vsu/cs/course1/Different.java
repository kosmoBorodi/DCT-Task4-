package ru.vsu.cs.course1;

public class Different {
    public static int[][] toInt(double[][] matrix) {
        double[][] tmp = copyOfMatrix(matrix);
        int[][] result = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = (int) Math.round(tmp[i][j]);
            }
        }
        return result;
    }

    public static double[][] prouz(double[][] matrix, double[][] stMatrix) {
        double[][] result = new double[matrix.length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                for (int i = 0; i < matrix.length; i++) {
                    result[row][column] += ceilToMil(matrix[row][i] * stMatrix[i][column]);
                }
            }
        }
        return result;
    }

    public static double[][] prouz(double[][] matrix, int[][] stMatrix) {
        double[][] result = new double[matrix.length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                for (int i = 0; i < matrix.length; i++) {
                    result[row][column] += matrix[row][i] * stMatrix[i][column];
                }
            }
        }
        return result;
    }

    public static int[][] swap(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = row + 1; column < matrix[0].length; column++) {
                int intermediateVar = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = intermediateVar;
            }
        }
        return matrix;
    }

    public static double[][] swap(double[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = row + 1; column < matrix[0].length; column++) {
                double intermediateVar = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = intermediateVar;
            }
        }
        return matrix;
    }

    public static double[][] copyOfMatrix(double[][] matrix) {
        double[][] copy = new double[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                copy[row][column] = matrix[row][column];
            }
        }
        return copy;
    }

    public static int[][] copyOfMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                copy[row][column] = matrix[row][column];
            }
        }
        return copy;
    }

    public static double ceilToSot(double var) {
        var = (int) Math.round(var * 100);
        return var / 100;
    }

    public static double ceilToMil(double var) {
        var = (int) Math.round(var * Math.pow(10, 7));
        return var / Math.pow(10, 7);
    }
}
