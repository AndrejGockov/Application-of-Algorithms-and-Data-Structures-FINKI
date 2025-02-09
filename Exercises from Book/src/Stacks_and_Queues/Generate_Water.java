package Stacks_and_Queues;

import java.util.*;

public class Generate_Water {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Stack<Character>hydrogen = new Stack<>();
        Stack<Character>oxygen = new Stack<>();

        for(int i = 0; i < n; i++){
            char chemical = input.next().charAt(0);

            if(chemical == 'H')
                hydrogen.push(chemical);
            else
                oxygen.push(chemical);
        }

        int waterProduced = 0;

        while(!hydrogen.isEmpty() && !oxygen.isEmpty()){
            if(hydrogen.size() < 2)
                break;

            oxygen.pop();
            hydrogen.pop();
            hydrogen.pop();
            waterProduced++;
        }

        System.out.println(waterProduced);

        while(!hydrogen.isEmpty())
            System.out.print(hydrogen.pop() + " ");

        System.out.println();

        while(!oxygen.isEmpty())
            System.out.print(oxygen.pop() + " ");
    }
}
