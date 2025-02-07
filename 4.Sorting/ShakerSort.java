//        Дадена е низа со N природни броеви. Треба да се сортира низата со помош на таканареченото shaker (cocktail) сортирање. Ова сортирање е варијација на сортирањето со меурчиња (bubble sort) со тоа што во секоја итерација низата се изминува два пати. Во првото поминување најмалиот елемент се поместува на почетокот на низата, а при второто најголемиот елемент се поместува на крајот.
//        Во првиот ред од влезот даден е бројот на елементи во низата N, а во вториот ред се дадени броевите. На излез треба да се испечати низата по секое изминување во посебен ред.
//
//        Име на класата: ShakerSort
//
//        -------------------
//
//        Given a sequence of N natural numbers. The array should be sorted using the so-called shaker (cocktail) sort. This sort is a variation of the bubble sort in that in each iteration the array is traversed twice. In the first pass, the smallest element is moved to the beginning of the array, and in the second pass, the largest element is moved to the end.
//        In the first line of the input, the number of elements in the array N is given, and in the second line, the numbers are given. The output should print the string after each pass in a separate line.
//
//        Class Name: ShakerSort
//
//        For example:
//        Input:
//        8
//        6 10 13 5 8 17 2 5
//
//        Result:
//        2 6 10 13 5 8 17 5
//        2 6 10 5 8 13 5 17
//        2 5 6 10 5 8 13 17
//        2 5 6 5 8 10 13 17
//        2 5 5 6 8 10 13 17
//        2 5 5 6 8 10 13 17
//        2 5 5 6 8 10 13 17
//        2 5 5 6 8 10 13 17

import java.util.*;

public class ShakerSort {
    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapped;

        while (left < right) {
            swapped = false;

            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            printArray(arr);
            right--;

            if (!swapped) break;

            swapped = false;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            printArray(arr);
            left++;

            if (!swapped) break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? " " : "\n"));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        printArray(arr); // Print initial array state
        shakerSort(arr);
        printArray(arr); // Print final sorted array
    }
}
