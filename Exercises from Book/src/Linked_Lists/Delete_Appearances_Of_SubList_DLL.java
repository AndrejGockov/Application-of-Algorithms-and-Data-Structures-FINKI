package Linked_Lists;

import java.util.*;

public class Delete_Appearances_Of_SubList_DLL {
    public static boolean containsSubList(DLLNode<Integer>node, DLL<Integer>subList){
        // Go through the entire list and if at any point the sub list is found return true
        while(node != null){
            DLLNode<Integer>subNode = subList.getFirst();
            DLLNode<Integer>dummy = node;
            boolean isSubList = true;

            while(subNode != null && dummy != null){
                if(dummy.element != subNode.element){
                    isSubList = false;
                    break;
                }

                dummy = dummy.succ;
                subNode = subNode.succ;
            }

            if (isSubList)
                return true;

            node = node.succ;
        }

        return false;
    }

    public static DLL<Integer> deleteSubLists(DLLNode<Integer>node, DLL<Integer>subList){
        DLL<Integer>newList = new DLL<>();
        // Itterate through entire list and delete all sublists found while traversing
        while(node != null){
            DLLNode<Integer>subNode = subList.getFirst();
            DLLNode<Integer>dummy = node;
            boolean isSubNode = true;

            while(subNode != null && dummy != null){
                if(dummy.element != subNode.element){
                    isSubNode = false;
                    break;
                }
                subNode = subNode.succ;
                dummy = dummy.succ;
            }

            if(isSubNode)
                node = dummy;
            else {
                newList.insertLast(node.element);
                node = node.succ;
            }
        }
        return newList;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>list = new DLL<>();
        DLL<Integer>subList = new DLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        int m = input.nextInt();

        for(int i = 0; i < m; i++)
            subList.insertLast(input.nextInt());

        DLL<Integer>newList = new DLL<>();
        DLLNode<Integer>node = list.getFirst();
        DLLNode<Integer>subNode = subList.getFirst();
        boolean hasSubList = containsSubList(node, subList);

        while(hasSubList){
            node = deleteSubLists(node, subList).getFirst();
            hasSubList = containsSubList(node, subList);
        }

        while(node != null){
            newList.insertLast(node.element);
            node = node.succ;
        }

        if(newList.getSize() == 0)
            System.out.println("Prazna lista");
        else
            System.out.println(newList);
    }
}
