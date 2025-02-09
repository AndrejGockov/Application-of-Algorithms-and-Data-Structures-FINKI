package Stacks_and_Queues;

import java.util.*;

public class RGB_Balls {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int bomb = 0;
        Stack<Character>R = new Stack<>();
        Stack<Character>G = new Stack<>();
        Stack<Character>B = new Stack<>();

        for (int i = 0; i < n; i++){
            Character ball = input.next().charAt(0);

            if(ball == 'R'){
                R.push(ball);
                bomb++;

                if(bomb == 3){
                    R.pop();
                    R.pop();
                    R.pop();
                    bomb = 0;
                }
            }else if(ball == 'G'){
                G.push(ball);
                bomb = 0;
            }else{
                B.push(ball);
                bomb = 0;
            }
        }

        Stack<Character>RGB = new Stack<>();

        while(!R.isEmpty())
            RGB.push(R.pop());

        while(!G.isEmpty())
            RGB.push(B.pop());

        while(!B.isEmpty())
            RGB.push(B.pop());

        System.out.println(RGB);
//        System.out.println(bomb);
    }
}
