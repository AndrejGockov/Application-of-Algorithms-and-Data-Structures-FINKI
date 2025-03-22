//        На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
//        Ime Prezime budzhet ip_adresa vreme grad cena
//        Пример
//        Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
//        Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
//
//        Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
//
//        Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:
//
//        Од сите N лица на влез, кои купуваат билет за до истиот град
//        колку од нив се вклучиле подоцна од 11:59; и
//        од овие, кој од нив се вклучил најрано?
//        (погледнете го тест примерот!)
//
//        (доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
//
//
//
//
//        Ова ќе треба да го направите за сите M редови за тестирање!
//
//        Препорака, користете OBHT и/или CBHT.
//
//        For example:
//        Input:
//        5
//        Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
//        Mitko Janev      4350    132.28.112.200    12:15   Krusevo    4000
//        Sara Dobreva     2700    10.73.60.29       14:35   Bitola     2500
//        Mence Trajanova  4000    10.73.112.112     11:25   Bitola     4200
//        Viktor Jovev     2200    10.73.112.79      15:15   Strumica   1800
//
//        1
//        Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
//
//        Result:
//        City: Bitola has the following number of customers:
//        2
//        The user who logged on earliest after noon from that city is:
//        Sara Dobreva with salary 2700 from address 10.73.60.29 who logged in at 14:35
//
//        Input:
//        25
//        Marko Stankovic    1200       192.168.0.10     10:45  Skopje     1500
//        Ana Petrovska      800        192.168.0.20     15:00  Bitola     760
//        Stefan Jovanovic   1500       192.168.0.30     11:30  Ohrid      1100
//        Elena Pavlova      600        192.168.0.40     14:15  Tetovo     750
//        Ivan Mitrevski     1300       192.168.0.50     16:45  Veles      900
//        Mila Nikolova      900        10.0.1.10        10:00  Skopje     700
//        Kristina Ristevska 500        10.0.1.20        15:30  Bitola     1200
//        Darko Nikolic      1500       10.0.1.30        12:00  Ohrid      1500
//        Marija Filipova    850        10.0.1.40        17:45  Tetovo     600
//        Aleksandar Kosta   1000       10.0.1.50        13:15  Veles      1400
//        Petar Jovanovski   2000       172.16.5.10      08:45  Skopje     1000
//        Ivana Velickova    800        172.16.5.20      14:45  Bitola     700
//        Dejan Stojanov     900        172.16.5.30      13:30  Ohrid      1300
//        Tamara Ilijevska   1500       172.16.5.40      16:00  Tetovo     1700
//        Filip Atanasov     2100       172.16.5.50      09:00  Veles      2050
//        Simona Milanova    600        192.168.2.10     15:00  Skopje     650
//        Aleksandra Petrova 1200       192.168.2.20     14:30  Bitola     800
//        Goran Kostadinov   850        192.168.2.30     11:15  Ohrid      700
//        Maja Georgieva     1600       192.168.2.40     18:00  Tetovo     1200
//        Nikola Nikolovski  1400       192.168.2.50     08:30  Veles      1450
//        Lazar Angelov      700        10.1.2.10         09:45  Skopje     1200
//        Milena Stojanovska 1300       10.1.2.20         16:30  Bitola     900
//        Aleksandar Dimeski 800        10.1.2.30         11:15  Ohrid      850
//        Katerina Trajkoska 1500       10.1.2.40         14:45  Tetovo     1400
//        Viktor Pejkovski   950        10.1.2.50         13:00  Veles      800
//
//        5
//        Marko Stankovic    1200       192.168.0.10     10:45  Skopje     1500
//        Kristina Ristevska 500        10.0.1.20        15:30  Bitola     1200
//        Dejan Stojanov     900        172.16.5.30      13:30  Ohrid      1300
//        Maja Georgieva     1600       192.168.2.40     18:00  Tetovo     1200
//        Viktor Pejkovski   950        10.1.2.50         13:00  Veles      800
//
//        Result:
//        City: Skopje has the following number of customers:
//        1
//        The user who logged on earliest after noon from that city is:
//        Simona Milanova with salary 600 from address 192.168.2.10 who logged in at 15:00
//
//        City: Bitola has the following number of customers:
//        5
//        The user who logged on earliest after noon from that city is:
//        Aleksandra Petrova with salary 1200 from address 192.168.2.20 who logged in at 14:30
//
//        City: Ohrid has the following number of customers:
//        2
//        The user who logged on earliest after noon from that city is:
//        Darko Nikolic with salary 1500 from address 10.0.1.30 who logged in at 12:00
//
//        City: Tetovo has the following number of customers:
//        5
//        The user who logged on earliest after noon from that city is:
//        Elena Pavlova with salary 600 from address 192.168.0.40 who logged in at 14:15
//
//        City: Veles has the following number of customers:
//        3
//        The user who logged on earliest after noon from that city is:
//        Viktor Pejkovski with salary 950 from address 10.1.2.50 who logged in at 13:00

import java.util.Scanner;

class People {
    String name, surname;
    String ipAdress, time, city;;
    int budget, price;

    People(){}

    People(String name, String surname, int budget, String ipAdress, String time, String city, int price){
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ipAdress = ipAdress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    public boolean isBeforeNoon(){
        return Integer.parseInt(time.substring(0, 2)) < 12;
    }

    @Override
    public String toString(){
        return name + " " + surname + " with salary " + budget + " from address " + ipAdress + " who logged in at " + time;
    }
}

public class In_Lab {
    public static boolean compareTime(String earliest, String curr){
        int a = (Integer.parseInt(earliest.substring(0, 2)) * 1000) + Integer.parseInt(earliest.substring(2, 3));
        int b = (Integer.parseInt(curr.substring(0, 2)) * 1000) + Integer.parseInt(curr.substring(2, 3));

        return a < b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        CBHT<String, Integer>hash = new CBHT<>(n);
        CBHT<String, People>cityOpyimal = new CBHT<>(n);


        for(int i = 0; i < n; i++){
            String name = input.next();
            String surname = input.next();
            int budget = input.nextInt();
            String ipAdress = input.next();
            String time = input.next();
            String city = input.next();
            int price = input.nextInt();
            People person = new People(name, surname,  budget,  ipAdress,  time,  city,  price);

            if(!person.isBeforeNoon()){
                if(i == 0){
                    cityOpyimal.insert(city, person);
                }else{
                    if(cityOpyimal.search(city) != null){
                        People previousOptimal = cityOpyimal.search(city).element.value;

                        if(time.compareTo(previousOptimal.time) < 0)
                            cityOpyimal.insert(city, person);
                    }else{
                        cityOpyimal.insert(city, person);
                    }
                }

                SLLNode<MapEntry<String, Integer>>node = hash.search(city);
                if (node == null) {
                    hash.insert(city, 1);
                    continue;
                }

                hash.insert(city, node.element.value + 1);
            }
        }

        int m = input.nextInt();

        for(int i = 0; i < m; i++){
            String name = input.next();
            String surname = input.next();
            int budget = input.nextInt();
            String ipAdress = input.next();
            String time = input.next();
            String city = input.next();
            int price = input.nextInt();

            SLLNode<MapEntry<String, Integer>>numberOfCustomers = hash.search(city);
            SLLNode<MapEntry<String, People>>optimalUser = cityOpyimal.search(city);

            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(numberOfCustomers.element.value);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(optimalUser.element.value);
            System.out.println();
        }
    }
}