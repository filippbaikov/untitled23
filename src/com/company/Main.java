package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] arr = new String[][]{{"17", "21", "73", "4",}, {"2", "18", "2", "27"}, {"1", "25", "2", "26"}, {"2", "2", "2", "2"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("неправильный размер массива!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Тебе сказали цифры лепи!");
            System.out.println("Ошибка : координаты: " + e.i + "x" + e.j);
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count+ Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
    }
}
