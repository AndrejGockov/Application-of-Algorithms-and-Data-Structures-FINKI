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
//
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
//
//        Example of invalid code (missing closing tag for func3):
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc1
//
//        Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
//
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
//
//        Input:
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc1
//        x
//
//        Result:
//        Invalid


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean isValid = true;
        String command = "";
        Stack<String>stack = new Stack<>();

        while(true){
            command = input.nextLine();

            if(command.equals("x"))
                break;

            // If the first 4 letters in the command are "func" then it means its a new command
            if(command.substring(0, 4).equals("func"))
                stack.push(command);

            // If the first 3 are "end" we need to end a command
            if(command.substring(0, 3).equals("end")){
                // Checks if the names of the functions are the same
                if(!stack.isEmpty()
                        && command.substring(3).equals(stack.peek())){
                    stack.pop();
                }else{
                    isValid = false;
                    break;
                }
            }
        }

        if(isValid && stack.isEmpty()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}