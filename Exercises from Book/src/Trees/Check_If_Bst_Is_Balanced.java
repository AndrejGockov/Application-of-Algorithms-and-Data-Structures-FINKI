package Trees;

import java.util.*;

public class Check_If_Bst_Is_Balanced {
    public static int maxHeight(BNode<Integer>tree){
        if(tree == null)
            return 0;

        return 1 + Math.max(maxHeight(tree.left), maxHeight(tree.right));
    }

    public static boolean isBalanced(BNode<Integer>tree){
        if(tree == null)
            return true;

        int left = maxHeight(tree.left);
        int right = maxHeight(tree.right);

        return Math.abs(left - right) <= 1 && isBalanced(tree.left) && isBalanced(tree.right);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BinarySearchTree<Integer>tree = new BinarySearchTree<>();

        for(int i = 0; i < n; i++){
            String command = input.next();

            if(command.equals("insert")){
                tree.insert(input.nextInt());
            }

            if(command.equals("ask")){
                BNode<Integer>node = tree.getRoot();
                System.out.println(isBalanced(node));
            }
        }
    }
}
