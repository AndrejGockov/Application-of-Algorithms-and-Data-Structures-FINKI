package Linked_Lists;

import java.util.*;

public class Merge_Sorted_Lists {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>lOne = new SLL<>();
        SLL<Integer>lTwo = new SLL<>();

        for(int i = 0; i < n; i++)
            lOne.insertLast(input.nextInt());

        for(int i = 0; i < n; i++)
            lTwo.insertLast(input.nextInt());

        System.out.println(lOne);
        System.out.println(lTwo);

        SLL<Integer>merged = new SLL<>();
        SLLNode<Integer>nodeOne = lOne.getFirst();
        SLLNode<Integer>nodeTwo = lTwo.getFirst();

        while(nodeOne != null && nodeTwo != null){
            if(nodeOne.element.compareTo(nodeTwo.element) < 0){
                merged.insertLast(nodeOne.element);
                nodeOne = nodeOne.succ;
            }else{
                merged.insertLast(nodeOne.element);
                nodeTwo = nodeTwo.succ;
            }
        }

        if(nodeOne!=null){
            while(nodeOne != null){
                merged.insertLast(nodeOne.element);
            }
        }

        if(nodeTwo!=null){
            while(nodeTwo != null){
                merged.insertLast(nodeTwo.element);
            }
        }

        System.out.println(merged);
    }
}
