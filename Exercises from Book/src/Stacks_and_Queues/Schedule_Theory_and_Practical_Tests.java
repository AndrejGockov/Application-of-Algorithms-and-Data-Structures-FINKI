package Stacks_and_Queues;

import java.util.*;

public class Schedule_Theory_and_Practical_Tests {
    public static void main(String args[]){
        // Gargbage code needs no comments, with much love <3
        Scanner input = new Scanner(System.in);

        int theoryCount = input.nextInt();
        Queue<String>theory = new LinkedList<>();

        for(int i = 0; i < theoryCount; i++)
            theory.add(input.next());

        int practicalCount = input.nextInt();
        Queue<String>practical = new LinkedList<>();

        for(int i = 0; i < practicalCount; i++)
            practical.add(input.next());

        int bothCount = input.nextInt();
        Queue<String>both = new LinkedList<>();

        for(int i = 0; i < bothCount; i++)
            both.add(input.next());

        // For theory
        int terminCounter = 1;
        System.out.println("Polagaat e-test:");

        while(!theory.isEmpty()){
            System.out.println("termin " + terminCounter);

            for(int i = 0; i < 20; i++){
                if(!theory.isEmpty()) {
                    System.out.println(theory.remove());
                }else if(!both.isEmpty()){
                    System.out.println(both.peek());
                    practical.add(both.remove());
                }else{
                    break;
                }
            }
            terminCounter++;
        }

        terminCounter = 1;
        System.out.println();
        System.out.println("Polagaat zadaci:");

        while(!practical.isEmpty()){
            System.out.println("termin " + terminCounter);

            for(int i = 0; i < 20; i++){
                if(!practical.isEmpty())
                    System.out.println(practical.remove());
                else
                    break;
            }
            terminCounter++;
        }

        if(both.isEmpty()){
            return;
        }

        terminCounter = 1;
        System.out.println();
        System.out.println("Polagaat zadaci:");

        while(!both.isEmpty()){
            System.out.println("termin " + terminCounter);

            for(int i = 0; i < 20; i++){
                if(!both.isEmpty())
                    System.out.println(both.remove());
                else
                    break;
            }
            terminCounter++;
        }
    }
}
