//        Во оваа задача ќе работите со два објекти „Вработени“ и „Проекти“.
//        Еден вработен е дефиниран со 2 вредности: Име (String), Возраст (цел број).
//        Еден проект е дефиниран со 2 вредности: Работно Време (цел број), Плата по час (цел број).
//        За даден проект вкупната плата се пресметува како производ на работното време и платата по час.
//        Вработените ќе добиваат понудени проекти, и треба да го изберат проектот од кој ќе добијат најголема плата (доколку имаат избор од повеќе проекти со иста најголема плата, тогаш првиот таков).
//        Ваша задача ќе биде да им помогнете на вработените со тоа што ќе искористите CBHT со 10 кофички каде што за секој вработен ќе ја чувате неговата најдобра понуда.
//        За хеш функција користете производ од возраста на вработениот и ASCII вредноста на првата буква од името на вработениот.
//
//        Влез:
//        Во првиот ред е даден еден цел број N кој го означува бројот на понуди. Потоа во следните N редови се дадени по 4 вредности, информациите за понудите, името и возраста на вработениот и работното време и платата од час на проектот соодветно:
//        N
//        name_1 age_1 time_1 rate_1
//        name_2 age_2 time_2 rate_2
//        ...
//        name_N age_N time_N rate_N
//
//        Излез:
//
//        Отпечатете ја целата табела (со готовиот toString метод).
//        Секој вработен да се печати во формат "<name, age>" каде на местото на name и age треба да стои името и возраста на вработениот соодветно (имплементирајте го ова во toString метод)
//        Секој проект да се печати во формат "<time, rate>" каде на местото на time и rate треба да стои работното време и платата по час на проектот соодветно (имплементирајте го ова во toString метод)
//
//        Пример:
//        Влез:
//        5
//        Martin 25 3 100
//        Jana 26 4 90
//        Martin 25 5 120
//        Jana 26 2 95
//        Nenad 20 6 80
//        Излез:
//        0:<<Nenad, 20>,<6, 80>>
//        1:
//        2:
//        3:
//        4:<<Jana, 26>,<4, 90>>
//        5:<<Martin, 25>,<5, 120>>
//        6:
//        7:
//        8:
//        9:
//
//        For example:
//        Input:
//        5
//        Martin 25 3 100
//        Jana 26 4 90
//        Martin 25 5 120
//        Jana 26 2 95
//        Nenad 20 6 80
//
//        Result:
//        0:<<Nenad, 20>,<6, 80>>
//        1:
//        2:
//        3:
//        4:<<Jana, 26>,<4, 90>>
//        5:<<Martin, 25>,<5, 120>>
//        6:
//        7:
//        8:
//        9:
//
//        Input:
//        4
//        Toni 45 10 500
//        Toni 42 30 600
//        Ana 20 10 300
//        Jana 20 15 350
//
//        Result:
//        0:<<Jana, 20>,<15, 350>> <<Ana, 20>,<10, 300>> <<Toni, 45>,<10, 500>>
//        1:
//        2:
//        3:
//        4:
//        5:
//        6:
//        7:
//        8:<<Toni, 42>,<30, 600>>
//        9:

// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи
import java.util.*;

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return (int)name.toCharArray()[0] * age;
    }
}

class Project {
    int workTime, payPerHour;

    Project(int workTime, int payPerHour) {
        this.workTime = workTime;
        this.payPerHour = payPerHour;
    }

    int price(){
        return workTime * payPerHour;
    }

    @Override
    public String toString() {
        return "<" + workTime + ", " + payPerHour + ">";
    }
}

public class Main {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        CBHT<Person, Project>hash = new CBHT<>(10);

        // Прочитајте ги податоците од влезот и пополнете ја табелата
        for(int i = 0; i < n; i++){
            String name = input.next();
            int age = input.nextInt();
            int workTime = input.nextInt();
            int payPerHour = input.nextInt();

            Person person = new Person(name, age);
            Project project = new Project(workTime, payPerHour);

            SLLNode<MapEntry<Person, Project>>node = hash.search(person);

            if(node == null || node.element.value.price() < project.price())
                hash.insert(person, project);
        }

        // отпечатете ја вашата табела
        System.out.println(hash);
    }
}