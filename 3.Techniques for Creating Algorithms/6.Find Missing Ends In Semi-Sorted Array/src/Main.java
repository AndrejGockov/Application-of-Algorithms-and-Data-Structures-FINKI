//        Дадена е низа од „речиси“ сортирани броеви во растечки редослед, во смисол дека во сортирана низа има неколку залутани броеви кои се надвор од редоследот. Залутаните броеви се секогаш мали броеви кои се наоѓаат подесно од нивното вистинско место.
//        Ваша задача е да ги најдете залутаните броеви, како и бројот на места што залутаниот број треба да се помести во лево за низата да биде сортирана.
//        НАПОМЕНА: Оптималното решение има сложеност помала од квадратна
//
//        Влез:
//        Во првиот ред е даден број N, големината на низата
//        Во наредните N редови се дадени броевите од низата.
//
//        Излез:
//        Во првиот ред се печати M, бројот на залутани броеви.
//        Во наредните M редови, се печати секој залутан број, како и бројот на места за кои треба да биде поместен во лево.
//
//
//        Забелешка: Залутаните броеви се растечки подредени еден во однос на друг, во смисол дека залутан број при поместување на лево нема да премине преку друг залутан број.
//
//        Пример:
//
//        Влез:
//
//        8
//        1
//        3
//        4
//        5
//        2
//        6
//        8
//        7
//
//        Излез:
//        2
//        2 3
//        7 1
//
//        Образложение:
//        Дадени се 8 броеви на влез. Од нив, бројот 2 и бројот 7 се надвор од своите места. Ако бројот 2 го поместиме за 3 места на лево, а бројот 7 го поместиме за 1 место на лево, низата ќе биде во сортиран редослед.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int findTruePosition(int lossyNumber, int[] sortedArr, int start, int end){
        int mid = (int)Math.floor((start + end) / 2);

        if(sortedArr[mid] == lossyNumber)
            return mid;

        if(sortedArr[mid] > lossyNumber)
            return findTruePosition(lossyNumber, sortedArr,  start, mid - 1);

        return findTruePosition(lossyNumber, sortedArr, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);
        int looseEnds = 0;
        int[] looseNumbers = new int[n];
        int[] truePosition = new int[n];

        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i - 1]){
                looseNumbers[looseEnds] = arr[i];
                truePosition[looseEnds] = i - findTruePosition(arr[i], sortedArr, 0, i);
                looseEnds++;
            }

        }

        System.out.println(looseEnds);

        for(int i = 0; i < looseEnds; i++){
            System.out.println(looseNumbers[i] + " " + truePosition[i]);
        }
    }
}