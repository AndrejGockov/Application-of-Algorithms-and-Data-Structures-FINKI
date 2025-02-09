package Trees;

import java.util.*;

public class Kth_Inorder_Successor {
    public static void bstToList(BNode<Integer> node, List<Integer>sortedBst){
        if(node != null) {
            bstToList(node.left, sortedBst);
            sortedBst.add(node.info);
            bstToList(node.right, sortedBst);
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        BinarySearchTree<Integer>bst = new BinarySearchTree<>();

        for(int i = 0; i < n; i++){
            String command = input.next();

            if(command.equals("insert")){
                bst.insert(input.nextInt());
            }

            if(command.equals("ask")){
                BNode<Integer>node = bst.getRoot();
                List<Integer>sortedBst = new ArrayList<>();
                bstToList(node, sortedBst);
                int index = sortedBst.indexOf(k);

                if(index - 1 != -1)
                    System.out.println("Kth smallest element is: " + sortedBst.get(index - 1));
                else
                    System.out.println("No such predecessor exists");

                if(index + 1 != sortedBst.size() + 1)
                    System.out.println("Kth biggest element is: " + sortedBst.get(index + 1));
                else
                    System.out.println("No such successor exists");
            }
        }
    }
}