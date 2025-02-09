package Stacks_and_Queues;

import java.util.*;

public class Check_Closed_Brackets {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        String expression = input.nextLine();
        String bracketTypes = "(){}[]";
        Stack<Character>brackets = new Stack<>();
        boolean isCorrect = true;


        System.out.println(expression);

        for(char i : expression.toCharArray()) {
            if(!bracketTypes.contains(Character.toString(i)))
                continue;

            if (i == '(' || i == '[' || i == '{') {
                brackets.push(i);
                continue;
            }

            if(brackets.isEmpty()){
                isCorrect = false;
                break;
            }

            if(brackets.peek() == '(' && i == ')'){
                brackets.pop();
                continue;
            }else if(brackets.peek() != '(' && i == ')'){
                isCorrect = false;
                break;
            }

            if(brackets.peek() == '[' && i == ']'){
                brackets.pop();
                continue;
            }else if(brackets.peek() != '[' && i == ']'){
                isCorrect = false;
                break;
            }

            if(brackets.peek() == '{' && i == '}'){
                brackets.pop();
                continue;
            }else if(brackets.peek() != '{' && i == '}'){
                isCorrect = false;
                break;
            }
        }

        if(isCorrect && brackets.isEmpty())
            System.out.println("Коректни");
        else
            System.out.println("Некоректни");
    }
}
