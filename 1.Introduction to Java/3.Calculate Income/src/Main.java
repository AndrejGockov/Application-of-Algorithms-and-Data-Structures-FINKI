//        За потребите на софтвер за евиденција на приходите остварени од вработените во одделот за продажба, да се дефинира класа QuarterlySales во која се чуваат бројот на продажби остварени во одреден квартал, приходот добиен од секоја продажба и бројот на кварталот.
//        Потоа, да се дефинира друга класа SalesPerson за кој се чува име (string) и низа од квартали (точно 4). За класите да се имплементираат соодветните конструктори и методи за правилно извршување на програмата. Да се имплементираат следните барања:
//
//        • Метод int sumSales(SalesPerson sp) кој ќе врати сума од сите приходи остварени од дадениот вработен во одделот за продажба во сите квартали.
//        • Метод SalesPerson salesChampion(SalesPerson [] arr) кој за дадената низа од работници ќе го врати работникот со најголем остварен приход (од сите квартали).
//        • Да се дополни main методот во кој ќе се иницијализира низа од вработени во одделот за продажба и квартали согласно влезните тест примери. Во првиот ред се чита број на вработени, а понатаму прво во еден ред се чита името, па за секој квартал во еден ред бројот на продажби, и во следниот ред приходот добиен од секоја од тие продажби.
//        • На стандарден излез да се испечати низата од вработени во одделот за продажба со помош на методата void table(SalesPerson [] arr) која за низата од вработени ќе отпечати приказ во следниот формат (за простор при печатење се користат три празни места):
//
//        For example:
//
//        Input:
//        5
//        Damian
//        3
//        2000 1500 1000
//        5
//        1000 1300 2500 800 1100
//        2
//        3000 2000
//        1
//        1700
//        Samantha
//        4
//        1500 2000 1700 1200
//        6
//        900 1200 1800 1100 1500 1300
//        3
//        2500 3000 2000
//        5
//        800 1000 1300 1200 900
//        Jackson
//        5
//        1300 1500 1600 1200 1400
//        4
//        1700 2100 2000 1900
//        6
//        900 1200 1500 1800 2000 2200
//        7
//        500 700 900 1100 1300 1500 1700
//        Olivia
//        2
//        3500 3000
//        3
//        2000 2500 3000
//        4
//        1500 1800 2100 2400
//        5
//        1000 1300 1600 1900 2200
//        Liam
//        6
//        1100 1400 1700 2000 2300 2600
//        7
//        500 700 900 1100 1300 1500 1700
//        8
//        800 1000 1200 1400 1600 1800 2000 2200
//        3
//        2700 3000 3300
//
//        Result:
//        SP   1   2   3   4   Total
//        Damian   4500   6700   5000   1700   17900
//        Samantha   6400   7800   7500   5200   26900
//        Jackson   7000   7700   9600   7700   32000
//        Olivia   6500   7500   7800   8000   29800
//        Liam   11100   7700   12000   9000   39800
//
//        SALES CHAMPION: Liam

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getRevenue(){
        int sum = 0;
        for(int i = 0; i < numOfSales; i++)
            sum += revenues[i];
        return sum;
    }

    @Override
    public String toString() {
        return "a";
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public String getName(){
        return name;
    }

    public int totalRevenue(){
        int sum = 0;
        for(int i = 0; i < quarters.length; i++)
            sum += quarters[i].getRevenue();
        return sum;
    }

    @Override
    public String toString() {
        String res = name;

        for(int i = 0; i < quarters.length; i++){
            res += "   " + Integer.toString(quarters[i].getRevenue());
        }
        res += "   " + Integer.toString(totalRevenue());
        return res;
    }

}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr){
        int indx = 0;
        int mostRevenue = arr[0].totalRevenue();

        for(int i = 0; i < arr.length; i++){
            if(mostRevenue < arr[i].totalRevenue()){
                mostRevenue = arr[i].totalRevenue();
                indx = i;
            }
        }

        return arr[indx];
    }

    public static void table(SalesPerson [] arr){
        System.out.print("SP");

        for(int i = 1; i <= 4; i++)
            System.out.print("   " + i);

        System.out.println("   Total");

        int salesPeople = arr.length;

        for(int i = 0; i < salesPeople; i++){
            System.out.println(arr[i].toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];

        for(int i=0;i<n;i++)
        {
            //your code goes here
            input.nextLine();
            String name = input.nextLine();
            QuarterlySales quarterlySales[] = new QuarterlySales[4];

            for(int j = 0; j < 4; j++){
                int numSales = input.nextInt();
                int revenues[] = new int[numSales];

                for(int k = 0; k < numSales; k++){
                    revenues[k] += input.nextInt();
                }

                quarterlySales[j] = new QuarterlySales(numSales, revenues, j + 1);
            }

            arr[i] = new SalesPerson(name, quarterlySales);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}