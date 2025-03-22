//        За дадена двојно поврзана листа од N цели броеви, треба да се најде бројот на елементи такви што просекот на елементите од пред него во листата е поголем од просекот на елементи после него во листата.
//
//        Влез: Првиот број од влезот е бројот на елементи во листата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
//
//        Излез: Бројот на елементи што го задоволуваат условот.
//
//        For example:
//        Input:
//        5
//        1 2 3 4 5
//
//        Result:
//        0
//
//        Input:
//        4
//        5 4 3 2
//
//        Result:
//        2

import java.util.Scanner;

public class From_Home {
    // prefixAverage() and suffixAverage() work fundementally the same
    // So this can explain both of them:
    // If the previous or successor is null then we return 0, since you can't get an average from 1 number
    // Then skip to the previous or the successor since we cannot use the current number
    // Then get the average of the remaining numbers on each side of the list
    public static float prefixAverage(DLLNode<Integer> list){
        if(list.pred == null)
            return 0;

        list = list.pred;
        float sum = 0;
        int cnt = 0;
        while(list != null){
            sum += list.element;
            cnt++;
            list = list.pred;
        }
        return sum / cnt;
    }

    public static float suffixAverage(DLLNode<Integer> list){
        if(list.succ == null)
            return 0;

        list = list.succ;
        float sum = 0;
        int cnt = 0;
        while(list != null){
            sum += list.element;
            cnt++;
            list = list.succ;
        }
        return sum / cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // n - length of list
        // numbers - numbers in list
        int n = input.nextInt();
        DLL<Integer> numbers =  new DLL<Integer>();

        for(int i = 0; i < n; i++){
            int number = input.nextInt();
            numbers.insertLast(number);
        }

        DLLNode<Integer> numberList = numbers.getFirst();
        // Stores number of times prefixAverage is greaterthan suffixAverage
        int ans = 0;

        while(numberList != null){
            // System.out.println("Pre " + prefixAverage(numberList));
            // System.out.println("Suff " + suffixAverage(numberList));
            if(prefixAverage(numberList) > suffixAverage(numberList)
                    && prefixAverage(numberList) != 0
                    && suffixAverage(numberList) != 0)
                ans++;
            numberList = numberList.succ;
        }

        System.out.println(ans);
    }
}