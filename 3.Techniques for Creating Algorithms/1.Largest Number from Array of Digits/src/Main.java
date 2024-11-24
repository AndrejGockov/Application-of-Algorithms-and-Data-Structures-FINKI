//        Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
//
//        Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
//
//
//        Излез: Најголемиот број кој може да се состави од тие цифри
//
//        /
//
//        We are given N digits. Write an algorithm that composes the largest possible number from those digits.
//
//        Input: The first number in the input is the number of digits N, then in the next line are the given digits.
//
//        Output: The maximum possible number containing those digits
//
//        For example:
//
//        Input:
//        5
//        1 2 3 4 5
//
//	      Result:
//        54321
//
//        Input:
//        7
//        9 7 3 7 9 3 1
//
//	      Result:
//        9977331

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        Arrays.sort(arr);
        String ans = "";
        for(int i = n - 1; i >= 0; i--)
            ans += arr[i];

        System.out.println(ans);
    }

}