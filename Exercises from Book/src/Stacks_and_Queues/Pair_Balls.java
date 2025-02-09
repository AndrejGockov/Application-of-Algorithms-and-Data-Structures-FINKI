package Stacks_and_Queues;

import java.util.*;

public class Pair_Balls {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String ballType = "";

        Stack<String>red = new Stack<>();
        Stack<String>green = new Stack<>();
        Stack<String>blue = new Stack<>();

        for(int i = 0; i < n; i++){
            ballType = input.next();

            if(ballType.contains("R")){
                if(red.isEmpty() || red.peek().equals(ballType))
                    red.push(ballType);
                else
                    red.pop();
            }

            if(ballType.contains("G")){
                if(green.isEmpty() || green.peek().equals(ballType))
                    green.push(ballType);
                else
                    green.pop();
            }

            if(ballType.contains("B")){
                if(blue.isEmpty() || blue.peek().equals(ballType))
                    blue.push(ballType);
                else
                    blue.pop();
            }
        }

        int unpairedBalls = red.size() + green.size() + blue.size();

        System.out.println(unpairedBalls);
        System.out.println("The balls without pairs are:");
        while(!red.isEmpty()) {
            System.out.print(red.pop() + " ");
        }

        while(!green.isEmpty())
            System.out.print(green.pop() + " ");

        while(!blue.isEmpty())
            System.out.print(blue.pop() + " ");
    }
}
