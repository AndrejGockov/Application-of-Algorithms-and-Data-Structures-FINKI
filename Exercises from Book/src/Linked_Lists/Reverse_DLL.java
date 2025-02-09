package Linked_Lists;

import java.util.*;

public class Reverse_DLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        System.out.println(list);

        DLL<Integer>newList = new DLL<>();
        DLLNode<Integer>node = list.getLast();

        while(node != null){
            newList.insertLast(node.element);
            node = node.pred;
        }

        System.out.println(newList);
    }
}
