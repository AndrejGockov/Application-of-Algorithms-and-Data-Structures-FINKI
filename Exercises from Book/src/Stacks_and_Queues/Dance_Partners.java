package Stacks_and_Queues;

import java.util.*;

public class Dance_Partners {
    public static int count = 0;
    public static String findMissing(Stack<String>male, Stack<String>female){
        String res = "";
        String maleType = male.peek();
        String femaleType = female.peek();

        while(!male.isEmpty() && !female.isEmpty()){
            male.pop();
            female.pop();
        }

        while(!male.isEmpty()){
            res += femaleType + " ";
            male.pop();
            count++;
        }

        while(!female.isEmpty()){
            res += maleType + " ";
            female.pop();
            count++;
        }
        return res;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String[] customers = line.split(" ");

        Stack<String> basicMale = new Stack<>(), basicFemale = new Stack<>();
        Stack<String> standardMale = new Stack<>(), standardFemale = new Stack<>();
        Stack<String> latinMale = new Stack<>(), latinFemale = new Stack<>();

        for (String candidate : customers) {
            if (candidate.equals("LM")) latinMale.push(candidate);

            if (candidate.equals("LZ")) latinFemale.push(candidate);

            if (candidate.equals("SM")) standardMale.push(candidate);

            if (candidate.equals("SZ")) standardFemale.push(candidate);

            if (candidate.equals("OM")) basicMale.push(candidate);

            if (candidate.equals("OZ")) basicFemale.push(candidate);
        }

        String missingPairs = "";
        missingPairs += findMissing(basicMale, basicFemale);
        missingPairs += findMissing(standardMale, standardFemale);
        missingPairs += findMissing(latinMale, latinFemale);

        System.out.println(count);
        System.out.println(missingPairs);
    }
}