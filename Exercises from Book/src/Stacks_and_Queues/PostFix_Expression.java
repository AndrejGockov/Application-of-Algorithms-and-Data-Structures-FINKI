package Stacks_and_Queues;

import java.util.*;

public class PostFix_Expression {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        Stack<Double>stack = new Stack<>();
        double ans = 0;

        for(char i : expression.toCharArray()){
            if(Character.isDigit(i)) {
                stack.push((double)i - '0');
            }else{
                double sum = stack.pop();
                switch(i){
                    case '+':
                        sum += stack.pop();
                        break;
                    case '-':
                        sum = stack.pop() - sum;
                        break;
                    case '*':
                        sum *= stack.pop();
                        break;
                    case '/':
                        sum = stack.pop() / sum;
                        break;
                }
                stack.push(sum);
            }
        }

        System.out.println(stack.pop());
    }
}
