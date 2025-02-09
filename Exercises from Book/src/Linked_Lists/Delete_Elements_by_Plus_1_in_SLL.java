package Linked_Lists;

import java.util.*;

public class Delete_Elements_by_Plus_1_in_SLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        System.out.println(list);

        SLL<Integer>newList = new SLL<>();
        SLLNode<Integer>node = list.getFirst();
        int counter = 1;

        // 1. Adds elements equal to counter then skip the next and increase counter
        // 2. Repeats until it reaches the end of the list
        while(node != null){
            int i = 0;
            while(node != null && i < counter) {
                newList.insertLast(node.element);
                node = node.succ;
                i++;
            }

            if(node == null)
                break;

            node = node.succ;
            counter++;
        }

        System.out.println(newList);
    }
}
