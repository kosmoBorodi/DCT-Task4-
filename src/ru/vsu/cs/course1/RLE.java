package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.Arrays;

public class RLE {
    public static String solve(int[] file) {
        StringBuilder result = new StringBuilder();
        StringBuilder unique =new StringBuilder("");
        int counter = 1;

        for (int i = 0; i < file.length - 1; i++) {
            if (file[i] == file[i + 1]) {
                if (!unique.toString().equals("")) {
                    result.append("0").append(toBinary(counter - 1, 7)).append(unique);
                    counter = 1;
                    unique = new StringBuilder("");
                }
            } else {
                if (unique.toString().equals("") && counter != 1) {
                    result.append("1").append(toBinary(counter, 7)).append(toBinary(file[i], 8));
                    counter = 0;
                } else {
                    unique.append(toBinary(file[i], 8));
                }
            }
            if (counter == 127) {
                if (unique.toString().equals("")) {
                    result.append("1").append(toBinary(counter, 7)).append(toBinary(file[i], 8));
                    counter = 0;
                } else {
                    result.append("0").append(toBinary(counter, 7)).append(unique);
                    counter = 0;
                    unique = new StringBuilder("");
                }
            }
            counter++;
        }
        if (file[file.length - 2] == file[file.length - 1]) {
            if (counter > 1 && unique.toString().equals("")) {
                result.append("1").append(toBinary(counter, 7)).append(toBinary(file[file.length - 1], 8));
            }
        } else {
            if (counter == 1 && unique.toString().equals("")) {
                result.append("0").append(toBinary(counter, 7)).append(toBinary(file[file.length - 1], 8));
            } else {
                result.append("0").append(toBinary(counter, 7)).append(unique).append(toBinary(file[file.length - 1], 8));
            }
        }
//        if (counter > 1 && unique.toString().equals("")) {
//            result.append("1").append(toBinary(counter, 7)).append(toBinary(file[file.length - 1], 8));
//        } else if (!unique.toString().equals("")) {
//            result.append("0").append(toBinary(counter, 7)).append(toBinary(file[file.length - 2], 8));
//            result.append(toBinary(file[file.length - 1], 8));
//        } else {
//            result.append("0").append(toBinary(counter, 7)).append(toBinary(file[file.length - 1], 8));
//        }
        return result.toString();
    }

    public static ArrayList<Integer> unSolve(String solve) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < solve.length(); i++) {
            if (!solve.substring(i, i + 1).equals(0 + "")) {
                for (int j = 0; j < Integer.parseInt(solve.substring(i + 1, i + 8), 2); j++) {
                    result.add(Integer.parseInt(solve.substring(i + 8, i + 16), 2));
                }
                i = i + 15;
            } else {
                for (int j = 0; j < Integer.parseInt(solve.substring(i + 1, i + 8), 2); j++) {
                    result.add(Integer.parseInt(solve.substring((i + 8) + 8 * j, i + 16 + 8 * j), 2));
                }
                i = i + 15 + 8 * (Integer.parseInt(solve.substring(i + 1, i + 8), 2) - 1);
            }
        }
        return result;
    }

    public static String toBinary(int a, int countOfBits) {
        StringBuilder result = new StringBuilder();
        String binaryString = Integer.toBinaryString(a);

        for (int i = binaryString.length(); i < countOfBits; i++) {
            result.append("0");
        }
        return (result.append(binaryString)).toString();
    }
//    Integer.toBinaryString(x)
}

