package HashTable;

import java.util.Scanner;

public class Find_Criminal_Using_DNA {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        CBHT<String, String> database = new CBHT<>(n * 2);

        for(int i = 0; i < n; i++){
            String name = input.next();
            String sample1 = input.next();
            String sample2 = input.next();

            database.insert(sample1, name);
            database.insert(sample2, name);
        }

        String sample1 = input.next();
        String sample2 = input.next();

        SLLNode<MapEntry<String, String>>databaseSearch = database.search(sample1);

        if(databaseSearch != null){
            System.out.println(databaseSearch.element.value);
            return;
        }

        databaseSearch = database.search(sample2);

        if(databaseSearch != null){
            System.out.println(databaseSearch.element.value);
            return;
        }

        System.out.println("Unknown");
    }
}
