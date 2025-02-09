package HashTable;

import java.util.Scanner;

public class Check_if_Student_Input_is_Correct {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        CBHT<String, Double> candidates = new CBHT<>(n);

        for(int i = 0; i < n; i++){
            String index = input.next();
            double gpa = input.nextDouble();
            candidates.insert(index, gpa);
        }

        int m = input.nextInt();
        CBHT<String, Double> documents = new CBHT<>(m);

        for(int i = 0; i < m; i++){
            String index = input.next();
            double gpa = input.nextDouble();
            documents.insert(index, gpa);
        }

        String student = input.next();

        SLLNode<MapEntry<String, Double>>candidateApplication = candidates.search(student);
        SLLNode<MapEntry<String, Double>>studentDocument = documents.search(student);

//        System.out.println(candidateApplication.element.value +" " + studentDocument.element.value);
        if(candidateApplication == null || studentDocument == null){
            System.out.println("Empty");
            return;
        }

        if(!candidateApplication.element.value.equals(studentDocument.element.value)){
            System.out.println("Error");
            return;
        }

        System.out.println("OK");
    }
}
