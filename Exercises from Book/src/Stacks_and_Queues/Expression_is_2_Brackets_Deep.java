package Stacks_and_Queues;

import java.util.*;

public class Expression_is_2_Brackets_Deep {
    public static boolean isExpressionCorrect(String expression){
        Stack<Character>stack = new Stack<>();
        for(char i : expression.toCharArray()){
            if(i == '(')
                stack.push(i);

            if(i == ')' && !stack.isEmpty())
                stack.pop();
            else if(i == ')')
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean hasDuplicateBrackets(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
                continue;
            }

            if (stack.peek() == '(')
                return true; // Found duplicate brackets

            while (!stack.isEmpty() && stack.peek() != '(')
                stack.pop();

            stack.pop(); // Remove the opening '('
        }
        return false;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        // If expression is incorrect, discard expression
        if(!isExpressionCorrect(expression)){
            System.out.println("/");
            return;
        }

        if(hasDuplicateBrackets(expression)){
            System.out.println("Najdeni se dupli zagradi");
        }else{
            System.out.println("/");
        }
    }
}
