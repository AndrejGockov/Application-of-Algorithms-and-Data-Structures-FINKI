package Linked_Lists;

import java.util.*;

public class Make_List_ZigZag {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        DLL<Integer>list = new DLL<>();

        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        DLL<Integer>resultList = new DLL<>();
        DLLNode<Integer>node = list.getFirst();
        int cnt = 1;

        while(node != null){
            if(cnt % 2 == 1){
                System.out.println("Ascending");
            }else{
                System.out.println("Descending");
            }
            cnt++;

            node = node.succ.succ;
        }

        System.out.println(resultList);
    }
}
