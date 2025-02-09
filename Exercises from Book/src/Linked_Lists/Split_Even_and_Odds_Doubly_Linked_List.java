package Linked_Lists;

import java.util.*;

public class Split_Even_and_Odds_Doubly_Linked_List {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        DLL<Integer>even = new DLL<>();
        DLL<Integer>odd = new DLL<>();
        DLLNode<Integer>front = list.getFirst();
        DLLNode<Integer>back = list.getLast();

        while(front != back && back.succ != front){
            if(front.element % 2 == 0)
                even.insertLast(front.element);
            else
                odd.insertLast(front.element);

            if(back.element % 2 == 0)
                even.insertLast(back.element);
            else
                odd.insertLast(back.element);

            front = front.succ;
            back = back.pred;
        }

        if(front == back){
            if(front.element % 2 == 0)
                even.insertLast(front.element);
            else
                odd.insertLast(front.element);
        }

        System.out.println(even);
        System.out.println(odd);
    }
}
