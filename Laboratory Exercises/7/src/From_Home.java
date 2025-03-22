//        Во следната задача треба да изградите неподредено (општо) дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.
//        Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.
//
//        Влезот ќе содржи N+Q редови од видот
//        root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1
//        add parent_index child_index - Треба да додадете дете јазел со индекс child_index на јазелот со индекс parent_index
//        ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index
//
//        Пример и структура на влезот:
//        Влез:
//        11 5
//        root 1
//        add 1 2
//        add 2 3
//        ask 1
//        add 1 4
//        add 2 5
//        add 3 6
//        ask 2
//        add 3 7
//        ask 1
//        add 1 8
//        add 4 9
//        add 2 10
//        add 4 11
//        ask 2
//        ask 1
//
//        Излез:
//        1
//        2
//        4
//        4
//        7
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секое од 5те прашања во влезот
//        прашање 1: ask 1: Во поддрвото на јазелот 1 има 1 лист.
//        прашање 2: ask 2: Во поддрвото на јазелот 2 има 2 листови.
//        прашање 3: ask 1: Во поддрвото на јазелот 1 има 4 листови.
//        прашање 4: ask 2: Во поддрвото на јазелот 2 има 4 листови
//        прашање 5: ask 1: Во поддрвото на јазелот 1 има 7 листови
//
//        For example:
//        Input:
//        11 5
//        root 1
//        add 1 2
//        add 2 3
//        ask 1
//        add 1 4
//        add 2 5
//        add 3 6
//        ask 2
//        add 3 7
//        ask 1
//        add 1 8
//        add 4 9
//        add 2 10
//        add 4 11
//        ask 2
//        ask 1
//
//        Result:
//        1
//        2
//        4
//        4
//        7

import java.util.Scanner;

public class From_Home {
    public static <E> int countLeaves(SLLTree<E> tree, SLLTree.SLLNode<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.firstChild == null) {
            return 1;
        }

        int count = 0;
        SLLTree.SLLNode<E> child = node.firstChild;
        while (child != null) {
            count += countLeaves(tree, child);
            child = child.sibling;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        input.nextLine();

        SLLTree<Integer> tree = new SLLTree<Integer>();

        for(int i = 0; i < n + q; i++){
            String line = input.nextLine().trim();
            String[] cuts = line.split(" ");


            if(cuts[0].equals("root")) {
                tree.makeRoot(Integer.parseInt(cuts[1]));
            }

            if(cuts[0].equals("add")){
                SLLTree.SLLNode<Integer> parentNode =
                        (SLLTree.SLLNode<Integer>)tree.findNode(Integer.parseInt(cuts[1]), tree.root());
                tree.addChild(parentNode, Integer.parseInt(cuts[2]));
            }

            if(cuts[0].equals("ask")){
                SLLTree.SLLNode<Integer> queryNode =
                        (SLLTree.SLLNode<Integer>) tree.findNode(Integer.parseInt(cuts[1]), tree.root());
                System.out.println(countLeaves(tree, queryNode));
            }
        }
    }
}