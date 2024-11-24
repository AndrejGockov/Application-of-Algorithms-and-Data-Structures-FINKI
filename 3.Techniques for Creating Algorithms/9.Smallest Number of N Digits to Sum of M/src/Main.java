//        За дадена сума од цифри и број од цифри, да се најде најмалиот број чиј цифри ја формираат таа сума.
//
//        Влез: На влез се дадени два броја, N бројот на цифри и M сумата на цифри
//
//        Излез: На излез треба да се испечати најмалиот број со N цифри кој ја формира таа сума. Ако не постои таков број на излез да се испечати "Ne postoi"
//
//        Пример:
//
//        Влез:
//        2 10
//
//        Излез:
//        19
//
//        ----------------------------
//        For a given sum of digits N and a number of digits M, find the minimum number that forms the given sum of digits.
//
//        Input: The input contains two numbers, N- the number of digits and M- the sum of digit
//
//        Output: The smallest number with N digits and sum of digits M. If no such number exists print "Ne postoi"
//
//        Example:
//        Input:
//        10 2
//
//        Output:
//        19

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberLength = input.nextInt();
        int target = input.nextInt();

        // Min - number of digits that we can use to reach the target
        // Max - number of digits min isn't allowed to reach
        long min = (long)Math.pow(10, numberLength - 1);
        long max = (long)Math.pow(10, numberLength);

        // If min reaches max, then no number of numberLength digits exists that's equal to the target
        while(min < max){
            long currentNumber = min;
            int sum = 0;

            while(currentNumber > 0){
                sum += (currentNumber % 10);
                currentNumber /= 10;

                // If sum reaches target too early, we know it can't be equal to the target
                if(sum >= target)
                    break;
            }

            // If the sum is equal we've reached the target and the loop ends
            if(sum == target)
                break;
            min++;
        }

        if(min < max)
            System.out.println(min);
        else
            System.out.println("Ne postoi");
    }
}