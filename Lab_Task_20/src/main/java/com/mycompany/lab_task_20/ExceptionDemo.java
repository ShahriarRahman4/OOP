package com.mycompany.lab_task_20;

public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            int x = 10;
            int y = 0;
            int result = x / y;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        try {
            int[] arr = {1, 2, 3};
            int index = 4;
            int value = arr[index];
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }

        try {
            throw new CustomException("Custom exception occurred.");
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        } finally {
            System.out.println("End of the program.");
        }
    }
}
