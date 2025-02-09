package Stacks_and_Queues;

import java.util.*;

public class Consultations_Queues {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int apsLength = input.nextInt();
        String previousQuestionType = "";

        Queue<String>backOfTheLine = new LinkedList<>();
        Queue<String>finalOrder = new LinkedList<>();

        for(int i = 0; i < apsLength; i++){
            String name = input.next();
            String questionType = input.next();

            if(questionType.equals(previousQuestionType)){
                backOfTheLine.add(name);
            }else{
                finalOrder.add(name);
                previousQuestionType = questionType;
            }
        }

        int mmcLength = input.nextInt();

        for (int i = 0; i < mmcLength; i++){
            String name = input.next();
            finalOrder.add(name);
        }

        while(!backOfTheLine.isEmpty()){
            finalOrder.add(backOfTheLine.remove());
        }

        while (!finalOrder.isEmpty()){
            System.out.println(finalOrder.remove());
        }
    }
}
