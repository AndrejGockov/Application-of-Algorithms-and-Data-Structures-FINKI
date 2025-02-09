package Trees;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Find_Kth_Smallest_Element {
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

                System.out.println("Kth smallest element is: " + sortedBst.get(k - 1));
                System.out.println("Kth biggest element is: " + sortedBst.get(sortedBst.size() - k));
            }
        }
    }
}
