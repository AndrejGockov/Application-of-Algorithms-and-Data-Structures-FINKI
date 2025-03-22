//        Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//        Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//        ќе најдете на која длабочина се наоѓа елементот T во дрвото
//        Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//
//        Влезот ќе содржи N+Q редови од видот
//        insert value - Треба да ја вметнете вредноста value во дрвото.
//        ask value - Треба да одговорите на која длабочина во дрвото се наоѓа јазелот со вредност value
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
//        2
//        3
//        4
//        3
//        4
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секое од 7те прашања во влезот

import java.util.*;

public class From_Home {
    public static void findTarget(BNode<Integer>node, int target, int depth){
        if(node == null)
            return;

        depth++;
        if(node.info == target) {
            System.out.println(depth);
            return;
        }

        findTarget(node.left, target, depth);
        findTarget(node.right, target, depth);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();

        BinarySearchTree<Integer>tree = new BinarySearchTree<>();

        for(int i = 0; i < n + q; i++) {
            String command = input.next();
            int number = input.nextInt();

            if(command.equals("insert")){
                tree.insert(number);
            }

            if(command.equals("ask")){
                BNode<Integer> node = tree.getRoot();
                findTarget(node, number, 0);
            }
        }
    }
}