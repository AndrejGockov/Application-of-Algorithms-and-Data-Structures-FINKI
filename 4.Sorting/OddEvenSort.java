//        Дадена е низа со N природни броеви. Треба да се сортира низата така што во првиот дел од низата ќе бидат подредени непарните броеви од неа во растечки редослед, а во вториот дел парните броеви во опаѓачки редослед.
//        Во првиот ред од влезот даден е бројот на елементи во низата N, а во вториот ред се дадени броевите. На излез треба да се испечати сортираната низа.
//
//        Име на класата: OddEvenSort
//
//        ----------------
//
//        Given a sequence of N natural numbers. It is necessary to sort the sequence so that in the first part of the sequence the odd numbers from it will be sorted in ascending order, and in the second part the even numbers will be sorted in descending order.
//        In the first line of the input, the number of elements in the array N is given, and in the second line, the numbers are given. The output should print the sorted array.
//
//        Class Name: OddEvenSort
//
//        For example:
//        Input:
//        7
//        2 5 3 5 8 6 10
//
//        Result:
//        3 5 5 10 8 6 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int num : a) {
            if (num % 2 == 1) oddNumbers.add(num);
            else evenNumbers.add(num);
        }

        Collections.sort(oddNumbers);
        Collections.sort(evenNumbers, Collections.reverseOrder());

        int index = 0;
        for (int num : oddNumbers) {
            a[index++] = num;
        }
        for (int num : evenNumbers) {
            a[index++] = num;
        }
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = Integer.parseInt(pom[i]);
        }

        oddEvenSort(a, n);

        for (i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[i]);
    }
}
