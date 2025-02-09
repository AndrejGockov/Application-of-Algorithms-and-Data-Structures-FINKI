package Stacks_and_Queues;

import java.util.*;

public class PartialExam_Schedule_Assistents {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        // Assistents
        int assistentNum = input.nextInt();
        Queue<String>assistents = new LinkedList<>();

        for(int i = 0; i <assistentNum; i++)
            assistents.add(input.next());

        // Subjects
        int subjectNum = input.nextInt();
        String[] subjects = new String[subjectNum];
        int[] assistentsNeeded = new int[subjectNum];

        for(int i = 0; i < subjectNum; i++){
            subjects[i] = input.next();
            assistentsNeeded[i] = input.nextInt();
        }

        // Absent Assistents
        int absentNum = input.nextInt();
        HashSet<String>absentAssistents = new HashSet<>();

        for(int i = 0; i < absentNum; i++)
            absentAssistents.add(input.next());

        // Removes all the absent assistents from the queue
        for(int i = 0; i < assistentNum; i++) {
            if (!absentAssistents.contains(assistents.peek()))
                assistents.add(assistents.remove());
            else
                assistents.remove();
        }

//        System.out.println(assistents);

        for(int i = 0; i < subjectNum; i++){
            String firstAssistent = assistents.peek();

            System.out.println(subjects[i]);
            System.out.println(assistentsNeeded[i]);

            for(int j = 0; j < assistentsNeeded[i]; j++){
                // Prevents the same assistent from being assigned to the same space
                if(j != 0 && firstAssistent.equals(assistents.peek())){
                    break;
                }
                System.out.println(assistents.peek());
                assistents.add(assistents.remove());
            }
        }
    }
}
