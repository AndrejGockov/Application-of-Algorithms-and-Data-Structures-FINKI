package Stacks_and_Queues;

import java.util.*;

public class How_Many_Days_Before_Plants_Stop_Dying {
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]plants = new int[n];

        for(int i = 0; i < n; i++)
            plants[i] = input.nextInt();

        print(plants);
        int daysWithPlantsDying = 0;
        boolean plantDied = true;

        while(plantDied){
            plantDied = false;
            int[] newPlants = new int[n];
            int j = 1;
            newPlants[0] = plants[0];

            for(int i = 1; i < n; i++){
                if(plants[i - 1] < plants[i]){
                    plantDied = true;
                    continue;
                }

                newPlants[j] = plants[i];
                j++;
            }

            if(!plantDied)
                break;

            for(int i = 0; i < n; i++)
                plants[i] = newPlants[i];

            daysWithPlantsDying++;

            // Prints current status of the plants
            System.out.println(daysWithPlantsDying);
            print(plants);
        }

        System.out.println(daysWithPlantsDying);
    }
}