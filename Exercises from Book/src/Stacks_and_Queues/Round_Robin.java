package Stacks_and_Queues;

import java.util.*;

public class Round_Robin {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        String[] process = new String[n];
        int[] timeNeededToFinish = new int[n];
        int[] arrivalTime = new int[n];

        for(int i = 0; i < n; i++){
            process[i] = input.next();
            timeNeededToFinish[i] = input.nextInt();
            arrivalTime[i] = input.nextInt();
        }

        int timeAllocated = input.nextInt();

        // Sort based on arrival time and if two have the same arrival time but different time
        for(int i = 0; i < n - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arrivalTime[j] > arrivalTime[j + 1]
            || (arrivalTime[j] == arrivalTime[j + 1] && timeNeededToFinish[j] < timeNeededToFinish[j + 1])){
                    String temp = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp;

                    int tmp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j + 1];
                    arrivalTime[j + 1] = tmp;

                    tmp = timeNeededToFinish[j];
                    timeNeededToFinish[j] = timeNeededToFinish[j + 1];
                    timeNeededToFinish[j + 1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }


        // Add to queues
        Queue<String>processOrder = new LinkedList<>();
        Queue<Integer>timeRamaining = new LinkedList<>();

        for(int i = 0; i < n; i++){
            System.out.println(process[i] +  " "  + timeNeededToFinish[i] + " " + arrivalTime[i]);
            processOrder.add(process[i]);
            timeRamaining.add(timeNeededToFinish[i]);
        }

        // 1.Subtract the time left with the allocated time
        // 2.If its above 0 add it to the back of the queue
        // 3.Repeat until queue's empty
        while(!processOrder.isEmpty()){
            int timeLeft = timeRamaining.peek() - timeAllocated;
            System.out.print(processOrder.peek() + " ");

            if(timeLeft > 0){
                processOrder.add(processOrder.peek());
                timeRamaining.add(timeLeft);
            }

            processOrder.remove();
            timeRamaining.remove();
        }
    }
}
