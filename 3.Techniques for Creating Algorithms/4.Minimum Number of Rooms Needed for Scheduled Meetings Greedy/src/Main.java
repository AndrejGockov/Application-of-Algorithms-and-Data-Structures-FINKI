//        Дадени се N состаноци со време на почеток и крај. Да се најде минималниот број на сали за состаноци потребен за да се одржат сите состаноци.
//
//        Влез: Првиот број од влезот е бројот на состаноци N, а потоа во следниот ред минутата на почнување и минутата на завршување на состанокот.
//
//        Излез: Најмалиот потребен број на соби за состаноци за да можат да се одржат сите состаноци
//
//        /
//
//        We are given N scheduled meetings. Write an algorithm that finds the minimum number of meeting rooms needed to schedule those meetings.
//
//        Input: The first number in the input is the number of meetings N, then in the next N lines are the start and end time for each of the meetings.
//
//        Output: The minimum number of needed meeting rooms to schedule the meetings.
//
//        For example:
//        Input:
//        5
//        1 2
//        1 2
//        5 10
//        11 14
//        15 20
//
//        Result:
//        2
//
//        Input:
//        5
//        1 2
//        2 3
//        3 4
//        4 5
//        5 6
//
//        Result:
//        2

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] meetingStart = new int[n];
        int[] meetingEnd = new int[n];

        for(int i = 0; i < n; i++){
            meetingStart[i] = input.nextInt();
            meetingEnd[i] = input.nextInt();
        }

        Arrays.sort(meetingStart);
        Arrays.sort(meetingEnd);
        int maxMeetings = 1;
        int meetings = 1;

        int i = 0;
        int j = 1;

        while(i < n && j < n){
            if(meetingStart[i] <= meetingEnd[j]){
                meetings++;
               i++;
            }else{
                meetings--;
                j++;
            }

            maxMeetings = Math.max(maxMeetings, meetings);
        }

        System.out.println(maxMeetings);
    }
}