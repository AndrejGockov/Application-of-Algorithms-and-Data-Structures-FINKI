package Linked_Lists;

import java.util.*;

public class Divide_N_Words_Into_SLL {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String words = input.next();

        SLL<String>wordList = new SLL<>();
        SLL<Character>letterList = new SLL<>();

        String currWord = "";
        for(char i : words.toCharArray()){
            if(i == ',' && !currWord.equals("")){
                wordList.insertLast(currWord);
                currWord = "";
            }

            if(i != ',')
                currWord += i;

            letterList.insertLast(i);
        }

        if(!currWord.equals(""))
            wordList.insertLast(currWord);

        System.out.println(letterList);
        System.out.println(wordList);
    }
}
