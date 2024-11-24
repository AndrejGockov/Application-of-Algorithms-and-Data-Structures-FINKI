//        Дадени се N возови со време на пристигање и поаѓање. Да се најде минималниот број на платформи потребен за да се сместат тие возови.
//
//        Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
//
//        Излез: Најмалиот потребен број на платформи за да се сместат сите возови
//
//        /
//
//        We are given N trains. Write an algorithm that finds the minimum number of platforms needed to schedule those trains.
//
//        Input: The first number in the input is the number of trains N, then in the next N lines are the arrival and departure minutes for each of the trains.
//
//        Output: The minimum number of needed platforms to accommodate the trains.
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
    // Steps:
    // 1. Sort both the arrivals and departures
    // 2. Create 2 pointers for both sorted arrays,
    // arrivals starts at 1 because we don't care about when the first train arrives
    // 3. If the current departure is >= to the current arrival add a platform,
    // otherwise get rid of a platform
    // 4. Check on every loop for the max number of platforms
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arrivals = new int[n];
        int[] departures = new int[n];

        for(int i = 0; i < n; i++){
            arrivals[i] = input.nextInt();
            departures[i] = input.nextInt();
        }

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int maxPlatforms = 1;
        int platforms = 1;

        int arrivalTime = 1;
        int departureTime = 0;

        while(departureTime < n && arrivalTime < n){
            if(departures[departureTime] >= arrivals[arrivalTime]){
                platforms++;
                arrivalTime++;
            }else{
                platforms--;
                departureTime++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        System.out.println(maxPlatforms);
    }
}