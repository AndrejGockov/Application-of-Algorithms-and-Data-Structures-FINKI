//        Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//        Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//        ќе најдете колку елементи во дрвото се помали од T
//        Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//
//        Влезот ќе содржи N+Q редови од видот
//        insert value - Треба да ја вметнете вредноста value во дрвото.
//        ask value - Треба да одговорите колку елементи во дрвото имаат вредност помала од value
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
//        0
//        1
//        2
//        7
//        7
//        3
//        4
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секое од 7те прашања во влезот

import java.util.*;

public class In_Lab {
    public static int findGreaterThan(BNode<Integer>node, int target, int counter){
        if(node == null)
            return counter;

        if(node.info < target)
            counter++;

        if(node.left != null)
            counter += findGreaterThan(node.left, target, 0);

        if(node.right != null)
            counter += findGreaterThan(node.right, target, 0);

        return counter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();

        BinarySearchTree<Integer>tree = new BinarySearchTree<>();

        for(int i = 0; i < n + q; i++){
            String command = input.next();
            int value = input.nextInt();

            if(command.equals("insert")){
                tree.insert(value);
            }

            if(command.equals("ask")){
                BNode<Integer>node = tree.getRoot();
                System.out.println(findGreaterThan(node, value, 0));
            }
        }
    }
}