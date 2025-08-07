package com.mycompany.lab_task_5;

import java.util.Scanner;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array elements : ");
        String input = scanner.nextLine();

        String[] elements = input.split(" ");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }

        System.out.println("Choose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();

        System.out.println("Original array: " + Arrays.toString(arr));

        switch (choice) {
            case 1:
                Bubble_Sort bubbleSort = new Bubble_Sort();
                bubbleSort.n = arr.length;
                bubbleSort.arr = arr.clone();
                bubbleSort.Bubble();
                System.out.println("Array after Bubble Sort:");
                bubbleSort.Display();
                break;

            case 2:
                Selection_Sort selectionSort = new Selection_Sort();
                selectionSort.n = arr.length;
                selectionSort.arr = arr.clone();
                selectionSort.Selection();
                System.out.println("Array after Selection Sort:");
                selectionSort.Display();
                break;

            case 3:
                Merge_Sort mergeSort = new Merge_Sort();
                mergeSort.n = arr.length;
                mergeSort.arr = arr.clone();
                mergeSort.Merge();
                System.out.println("Array after Merge Sort:");
                mergeSort.Display();
                break;

            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
