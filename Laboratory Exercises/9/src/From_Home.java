//        Даден е неориентиран нетежински граф чии темиња се позитивни цели броеви. Да се најде бројот на патишта во графот, почнувајќи од фиксно теме V, кај кои сумата на темињата има вредност N. Темињата во патот може да се повторуваат.
//
//        Влез: Во првиот ред е даден бројот на рабови во графот M. Потоа во следните M редови се дадени рабовите во графот во формат теме1 теме2. Во претпоследниот ред е дадено почетното теме V, a во последниот ред е дадена бараната сума N.
//        Излез:  Бројот на патишта во графот кај кои сумата на темињата изнесува N.
//
//        Пример:
//        Влез:
//        6
//        2 5
//        2 3
//        5 3
//        5 1
//        3 1
//        3 4
//        5
//        10
//
//        Излез:
//        3
//        (Објаснување: патеките се 5-2-3, 5-3-2, 5-1-3-1)
//
//        /
//
//        Given an undirected unweighted graph whose vertices are positive integers, find the number of paths in the graph, starting from a fixed vertex V, such that the sum of the vertices is N. The vertices in the path can be repeated.
//
//        Input: The first line contains the number of edges in the graph M, followed by the edges in the next M lines. The edges are given in the format vertex1 vertex2. The second-to-last line contains the start vertex V and the last line contains the wanted sum N.
//
//        Output: The number of paths where the sum of the vertices is N.
//
//        Example:
//        Input:
//        6
//        2 5
//        2 3
//        5 3
//        5 1
//        3 1
//        3 4
//        5
//        10
//
//        Output:
//        3
//        (Explanation: the paths are 5-2-3, 5-3-2, 5-1-3-1)
//
//        For example:
//        Input:
//        6
//        2 5
//        2 3
//        5 3
//        5 1
//        3 1
//        3 4
//        5
//        10
//
//        Result:
//        3

import java.util.*;
import java.util.Map.Entry;

public class From_Home {
    // 1. Goes through every node connected to the start variable
    // 2. Checks if the currSum is equal to target if so increase the counter
    // 3. If the currSum is greater than the target return 0 as there isn't any sub-path that works from this point
    // 4. Call the function again with current neighbor to check for any sub-paths that could equate to the target\
    public static int totalTargetPaths(AdjacencyListGraph<Integer>graph, int start, int target, int counter, int currSum){
        for(int i : graph.getNeighbors(start)){
            if(currSum + i == target) {
                counter++;
                return counter;
            }

            if(currSum > target)
                return 0;

            counter+= totalTargetPaths(graph, i, target, 0, currSum+i);
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        AdjacencyListGraph<Integer>graph = new AdjacencyListGraph<>();

        for(int i = 0; i < n; i++){
            graph.addEdge(input.nextInt(), input.nextInt());
        }
        int start = input.nextInt();
        int target = input.nextInt();

        System.out.println(totalTargetPaths(graph, start, target, 0, start));
    }
}