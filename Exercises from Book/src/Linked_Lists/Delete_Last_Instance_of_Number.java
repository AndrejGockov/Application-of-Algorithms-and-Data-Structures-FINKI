package Linked_Lists;

import java.util.*;

public class Delete_Last_Instance_of_Number {
    public static boolean containsNumber(SLLNode<Integer>node, int number){
        while(node != null){
            if(node.element == number)
                return true;
            node = node.succ;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        for(int i = 0; i < n; i++){
            list.insertLast(input.nextInt());
        }

        System.out.println(list);

        int target = input.nextInt();
        SLL<Integer>newList = new SLL<>();
        SLLNode<Integer>node = list.getFirst();

        while(node != null){
            if(node.element == target && !containsNumber(node.succ, target)) {
                node = node.succ;
                continue;
            }

            newList.insertLast(node.element);
            node = node.succ;
        }

        System.out.println(newList);
    }
}