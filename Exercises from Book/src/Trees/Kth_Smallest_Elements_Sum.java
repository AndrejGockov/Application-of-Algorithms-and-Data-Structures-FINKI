package Trees;

import java.util.*;

public class Kth_Smallest_Elements_Sum {
    public static void bstToList(BNode<Integer> node, List<Integer> sortedBst){
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

                int sum = 0;

                // Incase k is bigger than the current size of the tree
                int indx = k;
                if(k > sortedBst.size())
                    indx -= (k - sortedBst.size());

                for(int j = 0; j < indx; j++)
                    sum += sortedBst.get(j);

                System.out.println(sortedBst);
                System.out.println(sum);
            }
        }
    }
}