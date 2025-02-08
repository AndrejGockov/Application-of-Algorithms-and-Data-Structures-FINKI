//Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//
//        Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//
//        ќе најдете колку елементи во дрвото се поголеми од T
//        Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//
//        Влезот ќе содржи N+Q редови од видот:
//        insert value - Треба да ја вметнете вредноста value во дрвото.
//        ask value - Треба да одговорите колку елементи во дрвото имаат вредност поголема од value
//
//        Пример и структура на влезот:
//        Влез:
//        10 7
//        insert 6
//        insert 3
//        insert 7
//        ask 3
//        ask 6
//        insert 4
//        insert 1
//        insert 2
//        insert 5
//        insert 9
//        ask 3
//        ask 9
//        insert 8
//        insert 10
//        ask 8
//        ask 4
//        ask 5
//
//        Излез:
//        2
//        1
//        5
//        0
//        2
//        6
//        5
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секое од 7те прашања во влезот

import java.util.Scanner;

public class Main {
    public static int countElements(BNode<Integer>tree ,int threshold, int count){
        if(tree == null)
            return count;

        if(tree.info > threshold)
            count++;

        count += countElements(tree.left, threshold, 0) + countElements(tree.right, threshold, 0);

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        BinarySearchTree<Integer>tree = new BinarySearchTree<>();

        for(int i = 0; i < n + m; i++){
            String command = input.next();

            if(command.equals("insert")){
                int value = input.nextInt();
                tree.insert(value);
            }

            if(command.equals("ask")){
                int threshold = input.nextInt();
                BNode<Integer>treeNode = tree.getRoot();
                System.out.println(countElements(treeNode, threshold, 0));
            }
        }
    }
}