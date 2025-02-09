package Linked_Lists;

import java.util.*;

public class Zig_Zag_Elements_SLL {
    public static SLL<Integer> reverseList(SLL<Integer> list) {
        SLLNode<Integer> node = list.getFirst();
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.element);
            node = node.succ;
        }

        list.deleteList();
        while (!stack.empty())
            list.insertLast(stack.pop());

        return list;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        System.out.println(list);

        SLL<Integer> newList = new SLL<>();
        // Get the normal list and it's reversed version
        SLLNode<Integer> node = list.getFirst();
        SLLNode<Integer> nodeReversed = reverseList(list).getFirst();

        // Until the list is the original size:
        // 1. First always add from the normal list then the reversed
        // 2. If the list's length is odd don't add the last element as it will be duplicated
        while (newList.size() < list.size()){
            newList.insertLast(node.element);

            if(n % 2 == 1 && newList.size() < n)
                newList.insertLast(nodeReversed.element);
//            System.out.println(newList);
            node = node.succ;
            nodeReversed = nodeReversed.succ;
        }

        System.out.println(newList);
    }
}