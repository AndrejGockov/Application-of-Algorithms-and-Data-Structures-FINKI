//        Дадена е низа од N работни задачи, со проценето времетраење во часови, кои треба да се извршат во една компанија. Компанијата има на располагање M вработени кои работат по 8 часа на ден. Сите работни активности се помали или еднакви од 8 часа и не може да се извршат половично
//        Ваша задача е да ја распределите работата помеѓу вработените така што работните задачи ќе се извршат за најкраток можен рок.
//
//        Влез: На влез се дадени два броја, N, бројот на задачи и M бројот на вработени.
//        Во вториот ред на влезот дадени се N цели броеви кои го означуваат времетраењето на секоја задача.
//
//        Излез: На излез прво се печати бројот на работни денови потребни за да се извршат задачите. Потоа се печати збирот од вкупниот број на слободни часови кај сите вработени според вашата распределба.
//
//        Пример:
//
//        Влез:
//        7 2
//
//        8 7 3 5 1 3 1
//
//        Излез:
//        2 4
//        Појаснување:
//        Имаме двајца вработени. Првиот ден еден од вработените ќе ја изврши задачата од 8 часа, а вториот задачите од 7 и 1 час. Вториот ден еден од вработените ќе ги изврши задачите од 5 и 3 часа, а вториот задачите од 3 и 1 час. На овој вработен ќе му останат 4 слободни часа, па тоа го печатиме на излез.
//
//        ----------------------------
//
//        You are given an array of N work tasks, each with an estimated time for completion given in hours, which need to be done in a company. The company has M employees, each working 8 hours per day. All the work tasks are equal or less than 8 hours and cannot be split.
//        Your task is to distribute the working tasks among the workers, such that the tasks are finished in the least possible time.
//
//        Input: The input contains two numbers, N- the number of tasks and M-the number of employees.
//        The second line of the input contains N numbers- the estimated time for each task in hours.
//
//        Output: The first number in the output is the days needed to complete the tasks. The second number is the sum of free hours within those days among all of the employees.
//
//        Example:
//
//        Input:
//        5 2
//
//        8 7 3 5 1 3 1
//
//        Output:
//        2 4
//
//        Explanation:
//        We have two employees. The first day, one of the employees does the 8-hour task, the other employee the tasks of 1 and 7 hours. The second day, one of the employee does the 5 and 3 hours task, and the second one the 3-hours and the 1-hour task. This employee would have 4 free hours and we print that number as well.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 1. Input the array of tasks, add up how many hours it'll take, sort the list
    // 2. While te total time is greater than 0, theres more work that needs to be done
    // 3. As the employees are doing tasks decrement the hours they're working with the total time needed
    // 4. Track how many days they've worked and with how many hours
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int taskNum = input.nextInt();
        int[] tasks = new int[taskNum];
        int timeNeeded = 0;
        int employeeNum = input.nextInt();

        // Inputs length of each task and sums up to see total time needed
        for(int i = 0; i < taskNum; i++) {
            tasks[i] = input.nextInt();
            timeNeeded += tasks[i];
        }

        Arrays.sort(tasks);
        int daysTaken = 0;
        int freeTime = 0;

        // Takes the sorted list and itterates
        // While the timeNeeded > 0 there's still more work to be done
        while (timeNeeded > 0){
            // How many hours each employee has worked
            int hoursWorked = 0;

            // Itterate through every employee to see how many tasks they can do on a given day
            // If adding another task takes up more than 8 hours
            // it won't be added and they free time from that day will be added to freeTime
            for(int i = 0; i < employeeNum; i++){
                for(int j = 0; j < taskNum; j++){
                    if(hoursWorked + tasks[j] <= 8){
                        hoursWorked += tasks[j];
                        timeNeeded -= tasks[j];
                        tasks[j] = 0;
                    }

                    if(hoursWorked == 8)
                        break;
                }

                freeTime += (8 - hoursWorked);
                hoursWorked = 0;
            }
            daysTaken++;
        }

        System.out.println(daysTaken + " " + freeTime);

    }
}