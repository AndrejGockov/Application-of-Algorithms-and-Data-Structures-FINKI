//        Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.
//
//        Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.
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
//        Input:
//        5
//        1 2 3 4 5
//
//        Result:
//        54321
//
//        Input:
//        7
//        9 7 3 7 9 3 1
//
//        Result:
//        9977331

import java.util.Scanner;

public class From_Home {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int [n];

        for(int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        // Represented as string to be able to add 0's
        String highestNumber = "";

        for(int i = 0; i < n; i++){
            // Stores next digit to be added to the list
            int newDigit = arr[0];
            int indx = 0;

            // Adds biggest current digit in the list
            for(int j = 0; j < n; j++){
                if(newDigit < arr[j]){
                    newDigit = arr[j];
                    indx = j;
                }
            }

            // If all the digits are bellow 0 there are no new digits that can be added
            if(newDigit < 0)
                break;

            arr[indx] = -1;
            highestNumber += newDigit;
        }

        System.out.println(highestNumber);
    }
}