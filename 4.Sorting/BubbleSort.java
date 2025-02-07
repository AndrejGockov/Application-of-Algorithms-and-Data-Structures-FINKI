//        Дадена е една двојно поврзана листa и со N јазли кои во себе содржат по еден природен број. Треба да се сортира листата со помош на сортирањето со меурчиња (bubble sort).
//        Во првиот ред од влезот е даден бројот на јазли во листата, а потоа во вториот ред се дадени јазлите од кои е составена. На излез треба да се испечатат јазлите на сортираната листа.
//
//        Име на класата: BubbleSortDLL
//        Забелешка: При реализација на задачата МОРА да се користи дадената структура, а не да користат помошни структури како низи и сл.
//
//        -----------------
//
//        Given is a doubly linked list with N nodes that each contain a natural number. The list should be sorted using bubble sort.
//        In the first line of the input, the number of nodes in the list is given, and then in the second line, the nodes of which it is composed are given. The output should print the nodes of the sorted list
//
//        Class Name: BubbleSortDLL
//        Note: When performing the task, the given structure MUST be used, and not auxiliary structures such as arrays, etc.
//
//        For example:
//        Input:
//        8
//        6 10 13 5 8 17 2 5
//
//        Result:
//        2 5 5 6 8 10 13 17

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
