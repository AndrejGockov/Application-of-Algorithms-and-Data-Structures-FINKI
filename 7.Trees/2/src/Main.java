//        Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку внатрешни јазли има во поддрвото на избран јазол“.
//        Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.
//
//        Влезот ќе содржи N+Q редови од видот:
//        root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
//        add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
//        ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
//
//        Пример и структура на влезот:
//        Влез:
//        11 9
//        root bravo
//        add bravo echo LEFT
//        add echo beard LEFT
//        ask beard
//        ask bravo
//        add bravo foxtrot RIGHT
//        add beard hotel LEFT
//        add beard india RIGHT
//        ask echo
//        add foxtrot golf LEFT
//        add golf juliet RIGHT
//        add india sierra RIGHT
//        ask foxtrot
//        ask bravo
//        ask beard
//        add echo mike RIGHT
//        add foxtrot tango RIGHT
//        ask echo
//        ask bravo
//        ask foxtrot
//
//        Излез:
//        0
//        2
//        2
//        2
//        6
//        2
//        3
//        6
//        2
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секоја од 4те групи прашања во влезот

import java.util.*;

public class Main {
    public static int countNodesWithChildren(BNode<String>node){
        if(node == null)
            return 0;

        int count = 0;

        if(node.left != null || node.right != null)
            count++;

        return count + countNodesWithChildren(node.left) + countNodesWithChildren(node.right);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        BTree<String>tree = new BTree<>();
        HashMap<String, BNode<String>>treeMap = new HashMap<>();

        for(int i = 0; i < n + m; i++){
            String command = input.next();

            if(command.equals("root")){
                String root = input.next();
                tree.makeRoot(root);
                treeMap.put(root, tree.root);
            }

            if(command.equals("add")){
                String parent = input.next();
                String child = input.next();
                String d = input.next();
                int direction = BNode.LEFT;
                if(d.equals("RIGHT"))
                    direction = BNode.RIGHT;

                BNode<String>node = tree.addChild(treeMap.get(parent),direction, child);
                treeMap.put(child, node);
            }

            if(command.equals("ask")){
                String val = input.next();
                BNode<String>node = treeMap.get(val);

                System.out.println(countNodesWithChildren(node));
            }
        }
    }
}
