package Linked_Lists;

import java.util.*;

public class Average_Between_Neighboors_DLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        System.out.println(list);

        DLLNode<Integer>node = list.getFirst();
        DLLNode<Integer>next = node.succ;

        while(node != null && next != null){
            int a = node.element;
            int b = next.element;
            Integer avg = Math.round((a + b) / 2);

            list.insertAfter(avg, node);
            node = next;
            next = next.succ;
        }

        System.out.println(list);
    }
}
