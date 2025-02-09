package Linked_Lists;

import java.util.*;

public class Merge_Lists_By_Adding_2Pairs_Per_List {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        // Input
        int n = input.nextInt();
        SLL<Integer>lOne = new SLL<>();

        for(int i = 0; i < n; i++)
            lOne.insertLast(input.nextInt());

        int m = input.nextInt();
        SLL<Integer>lTwo = new SLL<>();

        for(int i = 0; i < m; i++)
            lTwo.insertLast(input.nextInt());

        System.out.println("Original Lists:");
        System.out.println(lOne);
        System.out.println(lTwo);
        System.out.println();

        SLL<Integer>mergedList = new SLL<>();
        SLLNode<Integer>nodeOne = lOne.getFirst();
        SLLNode<Integer>nodeTwo = lTwo.getFirst();

        while(nodeOne != null && nodeTwo != null) {
            int i = 0;
            while(i < 2 && nodeOne != null){
                mergedList.insertLast(nodeOne.element);
                nodeOne = nodeOne.succ;
                i++;
            }

            i = 0;

            while(i < 2 && nodeTwo != null){
                mergedList.insertLast(nodeTwo.element);
                nodeTwo = nodeTwo.succ;
                i++;
            }
        }

        while(nodeOne != null){
            mergedList.insertLast(nodeOne.element);
            nodeOne = nodeOne.succ;
        }

        while(nodeTwo != null){
            mergedList.insertLast(nodeTwo.element);
            nodeTwo = nodeTwo.succ;
        }

        System.out.println(mergedList);
    }
}
