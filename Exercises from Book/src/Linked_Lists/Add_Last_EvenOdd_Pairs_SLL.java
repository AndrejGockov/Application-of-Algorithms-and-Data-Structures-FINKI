package Linked_Lists;

import java.util.*;

public class Add_Last_EvenOdd_Pairs_SLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        SLL<Integer>evenList = new SLL<>();
        SLL<Integer>oddList = new SLL<>();
        SLLNode<Integer>node = list.getFirst();

        while(node != null) {
            while(node.succ != null && node.element % 2 == 0 && node.succ.element % 2 == 0)
                node = node.succ;

            while(node.succ != null && node.element % 2 != 0 && node.succ.element % 2 != 0)
                node = node.succ;

            if(node.element % 2 == 0)
                evenList.insertLast(node.element);
            else
                oddList.insertLast(node.element);

            node = node.succ;
        }

        if(evenList.size() == 0){
            System.out.println("Prazna Lista");
        }else{
            System.out.println(evenList);
        }

        if(oddList.size() == 0){
            System.out.println("Prazna Lista");
        }else{
            System.out.println(oddList);
        }
    }
}
