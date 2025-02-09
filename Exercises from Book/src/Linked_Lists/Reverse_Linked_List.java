package Linked_Lists;

import java.util.*;

public class Reverse_Linked_List {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        for(int i = 0; i < n; i++){
            list.insertLast(input.nextInt());
        }

        System.out.println(list);

        list.mirror();
        System.out.println(list);

        Stack<Integer>stack = new Stack<>();
        SLLNode<Integer>node = list.getFirst();

        while(node != null){
            stack.push(node.element);
            node = node.succ;
        }

        list.deleteList();
        while(!stack.empty()){
            list.insertLast(stack.pop());
        }

        System.out.println(list);
    }
}
