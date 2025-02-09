package Linked_Lists;

import java.util.*;

public class Swap_Neighboors {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        for(int i = 0; i < n; i++){
            list.insertLast(input.nextInt());
        }

        System.out.println(list);
        SLL<Integer>newList = new SLL<>();
        SLLNode<Integer>node = list.getFirst();

        while(node != null){
            if(node.succ == null){
                newList.insertLast(node.element);
                break;
            }

            newList.insertLast(node.succ.element);
            newList.insertLast(node.element);
            node = node.succ.succ;
        }

        System.out.println(newList);
    }
}
