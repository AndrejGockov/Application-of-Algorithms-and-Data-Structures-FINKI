package Stacks_and_Queues;

import java.util.*;

public class Organize_Partial_Exam {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int numberOfStudentsPerTerm = input.nextInt();

        // Students who applied that they also have math
        int studentMath = input.nextInt();
        Queue<String>studentsWithMath = new LinkedList<>();

        for (int i = 0; i < studentMath; i++)
            studentsWithMath.add(input.next());

        // The rest of the students
        int restOfApplicants = input.nextInt();
        Queue<String>remainingStudents = new LinkedList<>();

        for(int i = 0; i < restOfApplicants; i++)
            remainingStudents.add(input.next());

        // List of students who actually have math
        int mathScheduleLength = input.nextInt();
        HashSet<String>mathSchedule = new HashSet<>();

        for(int i = 0; i < mathScheduleLength; i++)
            mathSchedule.add(input.next());

//        Print for checking if inputs are correct
//        System.out.println(studentsWithMath);
//        System.out.println(remainingStudents);
//        System.out.println(mathSchedule);


        Queue<String>finalSchedule = new LinkedList<>();

        // If the current student is found in the math schedule, they maintain their position in the queue
        // Otherwise they go to the back with the rest of the students
        for(int i = 0; i < studentMath; i++){
            if(mathSchedule.contains(studentsWithMath.peek())){
                finalSchedule.add(studentsWithMath.remove());
            }else{
                remainingStudents.add(studentsWithMath.remove());
            }
        }

        while(!remainingStudents.isEmpty()){
            finalSchedule.add(remainingStudents.remove());
        }

        // Prints the final schedule
        int groupCount = 1;
        while(!finalSchedule.isEmpty()){
            System.out.println(groupCount);
            groupCount++;
            for(int i = 0; i < numberOfStudentsPerTerm; i++) {
                if (finalSchedule.isEmpty())
                    break;

                System.out.println(finalSchedule.remove());
            }
        }
    }
}