package Linked_Lists;

import java.util.*;

public class Split_Numbers_Based_On_Average_DLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();
        int average = 0;

        for(int i = 0; i < n; i++){
            int number = input.nextInt();
            list.insertLast(number);
            average += number;
        }

        average /= n;

        DLL<Integer>lessThanAverage = new DLL<>();
        DLL<Integer>greaterThanAverage = new DLL<>();
        DLLNode<Integer>node = list.getLast();

        while(node != null){
            if(node.element > average){
                greaterThanAverage.insertLast(node.element);
            }else{
                lessThanAverage.insertLast(node.element);
            }
            node = node.pred;
        }

        System.out.println(lessThanAverage);
        System.out.println(greaterThanAverage);
    }
}
