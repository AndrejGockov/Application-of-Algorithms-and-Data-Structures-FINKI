package Linked_Lists;

import java.util.*;

public class Merge_Upper_Lower_Numbers_Unsorterd_SLL {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer>list = new SLL<>();

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < n; i++) {
            int num = input.nextInt();

            list.insertLast(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(list);

        SLL<Integer>lower = new SLL<>();
        SLL<Integer>upper = new SLL<>();
        SLLNode<Integer>node = list.getFirst();

        while(node != null){
            int low = Math.abs(min - node.element);
            int high = Math.abs(max - node.element);

            if(low > high){
                upper.insertLast(node.element);
            }else{
                lower.insertLast(node.element);
            }

            node = node.succ;
        }

        System.out.println(lower);
        System.out.println(upper);
    }
}
