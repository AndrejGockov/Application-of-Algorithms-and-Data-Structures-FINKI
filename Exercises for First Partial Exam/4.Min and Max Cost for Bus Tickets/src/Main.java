//        На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно за соседниот град МинТаун. Цената на еден билет е 100 денари. Ако некој возрасен сака да патува со K деца, треба да плати еден билет за него и K-1 билети за децата (за едно дете не мора да плаќа билет). Исто така, возрасен може да се вози и сам, во тој случај ќе си плати еден билет за него. Дополнително знаеме дека децата не можат да се возат без да се придружени од некој возрасен.
//        Во првиот ред од влезот е даден бројот N. Во вториот ред е даден бројот M. Потребно е да пресметате колкав е минималниот и максималниот број на денари што може да ги платат патниците за билети и да ги испечатите во две линии. Во автобусот ќе има најмалку еден возрасен.
//
//        /
//
//        There were N adults and M children that wanted to travel from the bus station in FinTown to the neighbouring city MinTown. The price of one ticket is 100 den. If an adult wants to travel with K children, he would need to pay one ticket for him and K-1 tickets for the children (the ticket for one of the children is free). The adults can also travel by themselves, in which case they only pay one ticket. Additionally we know that the children can't travel without being accompanied by an adult.
//        In the first row the number N is given, and then in the second row the number M. You need to calculate the minimum and the maximum value in den. that the passengers can pay for their tickets, and print them in two separate lines. There will be at least one adult in the bus.
//
//        For example:
//
//        Input:
//        4
//        10
//
//	      Result:
//        1000
//        1300


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int min, max;

        if(M == 0){
            // If no adults are present
            max = min = N * 100;
        }
        else{
            // If there are more children than adults, the minimum is the number of adults
            // Otherwise the minimum is the number of adults
            if(N < M)
                min = M * 100;
            else
                min = N * 100;

            max = ((N + M) * 100) - 100;
        }

        System.out.println(min);
        System.out.println(max);
    }

}
