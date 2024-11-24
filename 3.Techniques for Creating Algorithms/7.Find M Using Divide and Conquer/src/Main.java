//        Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа. Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, да се најде бараниот број во таа низа и да се испечати неговата позиција. Доколку бројот не е во низата да е испечати "Ne postoi".
//        Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
//        Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.
//
//        /
//
//        We are given an array of N numbers. Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. If the number is found, print the position of the number in the array. If the number is not in the array, print "Ne postoi".
//        Input: The first number in the input is the size of the array N, and the number we are searching M. Then in the next line are the array elements.
//        Output: The position of the number we are searching, or "Ne postoi" if no such number exists in the array.
//
//        For example:
//
//        Input:
//        5 3
//        1 2 3 4 5
//
//        Result:
//        2
//
//        Input:
//        7 7
//        1 2 3 4 5 6 7
//
//        Result:
//        6

import java.util.Scanner;

public class Main {
    // mid - the middle of the array
    // If the start is greater than the end, then m isn't in the array so we return -1
    // If mid is greater than m, then it's in the first half of the array
    // Otherwise it's in the second half
    public static int findM(int m, int arr[], int start, int end){
        if(start > end)
            return -1;

        int mid = (int)Math.floor((start + end) / 2);

        if(arr[mid] == m)
            return mid;

        if(arr[mid] > m)
            return findM(m, arr, start, mid - 1);

        return findM(m, arr, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        int ans = findM(m, arr, 0, n - 1);

        if(ans == -1)
            System.out.println("Ne postoi");
        else
            System.out.println(ans);
    }
}