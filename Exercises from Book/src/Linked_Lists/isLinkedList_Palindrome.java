package Linked_Lists;

import java.util.*;

public class isLinkedList_Palindrome {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();

        for(int i = 0; i < n; i++){
            list.insertLast(input.nextInt());
        }

        DLLNode<Integer>start = list.getFirst();
        DLLNode<Integer>end = list.getLast();
        boolean isPalindrome = true;

        while(start != null && end != null){
            if(!start.element.equals(end.element)){
                isPalindrome = false;
                break;
            }
            start = start.succ;
            end = end.pred;
        }

        if (isPalindrome)
            System.out.println(1);
        else
            System.out.println(-1);
    }
}

