//        Даден е стринг. Треба да се најде најчестиот под-стринг кој е дел од него и да се испечати. Доколку два под-стринга се исто фреквентни, тогаш се печати подолгиот. Доколку и овој услов го исполнуваат тогаш се печати лексикографски помалиот.
//        Пример: За стрингот "abc" под-стрингови се "a", "b", "c", "ab", "bc", "abc". Сите имаат иста честота па затоа се печати најдолгиот "abc".
//
//        /
//
//        Given a string, you need to find the most frequent sub-string that is a part of the original and print it. If two sub-strings are equally frequent, you should print the longer one. If they are with the same length as well, then you should print the one that is lexicographically smaller.
//        Example: Sub-strings of the string "abc" are "a", "b", "c", "ab", "bc", "abc". They all have the same frequency, so the longest one is printed - "abc".
//
//        For example:
//        Input:
//        bab
//
//        Result:
//        b

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        CBHT<String,Integer> tabela = new CBHT<String,Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        /*
         *
         * Vashiot kod tuka....
         *
         */
        String ans = "";
        int count = 0;

        for(int i = 0; i < word.length(); i++){
            for(int j = i + 1; j <= word.length(); j++){
                SLLNode<MapEntry<String, Integer>>subString = tabela.search(word.substring(i, j));

                if(subString == null)
                    tabela.insert(word.substring(i, j), 1);
                else
                    tabela.insert(word.substring(i, j), subString.element.value + 1);

                // System.out.println(subString.element.key);
                subString = tabela.search(word.substring(i, j));


                // Updating most frequent substring
                if(count < subString.element.value){
                    ans = subString.element.key;
                    count = subString.element.value;
                }

                if(count != subString.element.value){
                    continue;
                }

                if(ans.length() < subString.element.key.length()){
                    ans = subString.element.key;
                    count = subString.element.value;
                }

                if(ans.length() == subString.element.key.length() && ans.compareTo(subString.element.key) > 0){
                    ans = subString.element.key;
                    count = subString.element.value;
                }
            }
        }
        System.out.println(ans);
    }
}