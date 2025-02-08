//        Дадено ви е бинарно пребарувачко дрво со N цели броеви.
//        Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
//        ќе најдете на која длабочина се наоѓа елементот T во дрвото
//        Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
//
//        Влезот ќе содржи N+Q редови од видот:
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

public class Main {
    public static int findElementDepth(BNode<Integer>node, int target, int depth){
        if(node == null)
            return 0;

        depth++;

        if(node.info == target)
            return depth;

        if(node.info < target)
            return findElementDepth(node.right, target, depth);

        return findElementDepth(node.left, target, depth);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        BinarySearchTree<Integer>bst = new BinarySearchTree<>();

        for(int i = 0; i < n + m; i++){
            String command = input.next();

            if(command.equals("insert")){
                int val = input.nextInt();
                bst.insert(val);
            }

            if(command.equals("ask")){
                int val = input.nextInt();
                BNode<Integer>node = bst.getRoot();
                System.out.println(findElementDepth(node, val, 0));
            }
        }
    }
}
