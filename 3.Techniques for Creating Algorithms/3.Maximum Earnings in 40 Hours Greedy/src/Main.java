//        Дадени се N задачи кои треба да се изработат. За секоја од задачите го знаеме времето за изработка (во часови) и заработката која ја носи. Да се најде максималната заработка во рок од една 40 часовна работна недела. Напомена дека и делумно сработени задачи носат делумна заработка, во зависност од процентот на завршеност.
//        Влез: Првиот број од влезот е бројот на задачи N, а потоа во следниот ред времетраењето на задачата во часови и заработката која ја носи.
//        Излез: Максимална заработка која можеме да ја направиме за 40 часа.
//
//        /
//
//        We are given N tasks with estimated completion time and the amount we can earn from that task. Write an algorithm that finds the maximum earnings we can have for 40 hours. Note that we can have a partial earning from a partially completed task.
//        Input: The first number in the input is the number of tasks N, then in the next N lines are the time needed for the task and the amount of money we can earn from it.
//        Output: The maximum amount we can earn in 40 hours
//
//        For example:
//
//        Input:
//        3
//        10 60
//        20 100
//        30 120
//
//        Result:
//        200
//
//        Input:
//        1
//        10 60
//
//        Result:
//        60

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] work = new int[n];
        int[] hours = new int[n];
        // Profit to cost ratio (work / hours)
        float[] workHoursRatio = new float[n];

        for (int i = 0; i < n; i++) {
            hours[i] = input.nextInt();
            work[i] = input.nextInt();
            workHoursRatio[i] = (float)work[i] / (float)hours[i];
        }

        // Sort the arrays based on the highest profit to work ratio
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(workHoursRatio[j] < workHoursRatio[j + 1]){
                    float tmp = workHoursRatio[j];
                    workHoursRatio[j] = workHoursRatio[j + 1];
                    workHoursRatio[j + 1] = tmp;

                    int temp = work[j];
                    work[j] = work[j + 1];
                    work[j + 1] = temp;

                    temp = hours[j];
                    hours[j] = hours[j + 1];
                    hours[j + 1] = temp;
                }
            }
        }

        int workDone = 0;
        int hoursWorked = 0;

        for(int i = 0; i < n; i++){
            // If adding more work will exceed 40 hours
            if(hoursWorked + hours[i] > 40){
                // Get the hours left divided by the ammount of hours needed to finish this work
                // Multiply that by the ammount of work
                float fractionalWork = (float)((40 - hoursWorked) / (float)hours[i]);
                fractionalWork = (float)work[i] * fractionalWork;

                workDone += (int)fractionalWork;
                hoursWorked = 40;
            }else{
                workDone += work[i];
                hoursWorked += hours[i];
            }

            // If it's equal to 40 hours worked, end the loop
            if(hoursWorked == 40)
                break;
        }

        System.out.println(workDone);
    }
}