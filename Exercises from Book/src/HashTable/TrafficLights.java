package HashTable;

import java.util.Scanner;

public class TrafficLights {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        CBHT<String, String> people = new CBHT<>(n);

        for(int i = 0; i < n; i++){
            String lisencePlate = input.next();
            String person = input.nextLine();
            people.insert(lisencePlate, person);
        }

        int speedLimit = input.nextInt();
        input.nextLine();
        String[] report = input.nextLine().split(" ");

        for(int i = 0; i < report.length - 2; i+=3){
            int speed = Integer.parseInt(report[i + 1]);
            if(speed > speedLimit){
                SLLNode<MapEntry<String, String>>person = people.search(report[i]);
                System.out.println(person.element.value);
            }
        }
    }
}
