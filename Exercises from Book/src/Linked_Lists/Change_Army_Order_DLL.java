package Linked_Lists;

import java.util.*;

public class Change_Army_Order_DLL {
    public static void main(String args[]){
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer>armyOrder = new DLL<>();

        for(int i = 0; i < n; i++)
            armyOrder.insertLast(input.nextInt());


    }
}
