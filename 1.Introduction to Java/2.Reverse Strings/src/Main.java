//      За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава број на зборови кои ќе се внесуваат. Во наредните линии се внесуваат самите зборови.
//
//      For example:
//
//      Input:
//      3
//      one
//      two
//      three
//
//      Result:
//      eno
//      owt
//      eerht

import java.util.Scanner;

public class Main {
    public static void printReversed(String word) {
        String ans = "";
        for(int i = 0;i < word.length(); i++)
            ans = word.charAt(i) + ans;
        System.out.print(ans);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String words;

        for(int i = 0; i <= n; i++){
            words = input.nextLine();
            printReversed(words);
            if(i != 0)
                System.out.println();
        }
    }
}