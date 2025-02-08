//        Дадено ви е бинарно пребарувачко дрво. Напишете рекурзивна функција inorderSuccessor која што за дадена вредност во дрвото ќе го најде нејзиниот следбеник.
//        /
//        Given a binary search tree, you need to write a recursive function inorderSuccessor that will return the successor of a given value.
//
//        For example:
//        10
//        8
//        2
//        11
//        6
//        0
//        9
//        19
//        3
//        14
//        16
//
//        Input	Result:
//        0
//        2
//        3
//        6
//        8
//        9
//        11
//        14
//        16
//        19

import java.util.*;
import binarysearchtree.BNode;
import binarysearchtree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for(int i = 0; i < n; i++){
            tree.insert(input.nextInt());
        }
        tree.printTree();
    }
}