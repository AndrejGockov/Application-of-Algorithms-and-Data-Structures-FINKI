package HashTable;

import java.util.Scanner;

public class Find_Incorrect_Words {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        CBHT<String, String> dictionary = new CBHT<>(n);

        for(int i = 0; i < n; i++){
            String word = input.next();
            if(dictionary.search(word) == null)
                dictionary.insert(word, word);

        }
        input.nextLine();

        String sentence = input.nextLine();
        System.out.println(sentence);
        String exceptions = ",./?! ";
        String currWord = "";

        for(char i : sentence.toCharArray()){
            if(exceptions.contains(Character.toString(i))){
                SLLNode<MapEntry<String, String>>node = dictionary.search(currWord);

                if(node == null)
                    System.out.println(currWord.toLowerCase());
                currWord = "";
                continue;
            }
            currWord += i;
//            System.out.println(currWord);
        }
    }
}