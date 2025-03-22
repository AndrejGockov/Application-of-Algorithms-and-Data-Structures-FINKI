//        Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija"). Ваша задача е да дефинирате дали даден програмски код е валиден.
//
//        Пример валиден код:
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc3
//        endfunc1
//
//        Пример невалиден код (испуштен е затворен таг за func3):
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc1
//
//        Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
//        Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
//
//        /
//
//        We are given code in a modified programming language is given, where functions are represented by an opening and closing tag ("functionName" and "endfunctionName"). Your task is to determine whether the given code is valid.
//
//        Example of valid code:
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc3
//        endfunc1
//
//        Example of invalid code (missing closing tag for func3):
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc1
//
//        Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
//        Output: "Valid" if the code is valid, "Invalid" if the code is not valid.
//
//        For example:
//        Input:
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc3
//        endfunc1
//        x
//
//        Result:
//        Valid

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class From_Home {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));

        String function = "";
        boolean valid = true;

        // Stack of opened functions and current number of functions opened
        Stack<Integer>openingFunctions = new Stack<Integer>();
        int openingCnt = 0;

        // Until x is entered keep entering functions
        while(function.length() != 1){
            function = input.readLine();
            // Last digit of the string
            int lastDigit = function.charAt(function.length() - 1) - '0';

            // If it starts with endfunc, then it's trying to close, if not it's opening a function
            if(function.contains("endfunc")){
                // If openingFunctions is empty theres nothing to close so it's invalid
                // If the last number tracked in openingFunctions isn't the same as the current one,
                // it's trying to close a different function than the last one inputed
                if(openingFunctions.isEmpty()
                        || openingFunctions.peek() != lastDigit){
                    valid = false;
                    break;
                }

                // Clears last function from stack
                openingFunctions.pop();
                openingCnt--;
            }else if(function.contains("func")){
                // Adds last function to stack
                openingCnt = lastDigit;
                openingFunctions.push(openingCnt);
            }
        }

        // If valid is false then a function wasn't closed properly
        // If openingFunctions isn't empty, then not every function was closed
        valid = valid && openingFunctions.isEmpty();

        if(valid)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

}