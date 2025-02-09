package Trees;

import java.util.*;

public class Sum_Of_All_Paths {
    public static int sumNumbers(BNode<Integer>node) {
        return sumOfPaths(node, 0);
    }

    public static int sumOfPaths(BNode<Integer>node, int sum){
        if(node == null)
            return 0;

        sum = sum * 10 + node.info;

        if(node.left == null && node.right == null)
            return sum;

        System.out.println(sum);
        return sumOfPaths(node.left, sum) + sumOfPaths(node.right, sum);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        BTree<Integer>tree = new BTree<>();
        HashMap<Integer, BNode<Integer>>treeMap = new HashMap<>();

        for (int i = 0; i < n; i++){
            String command = input.next();

            if(command.equals("root")){
                int root = input.nextInt();
                tree.makeRoot(root);
                treeMap.put(root, tree.root);
            }

            if(command.equals("add")){
                int parent = input.nextInt();
                int child = input.nextInt();
                String d = input.next();
                int direction = BNode.LEFT;
                if(d.equals("RIGHT"))
                    direction = BNode.RIGHT;

                BNode<Integer>node = tree.addChild(treeMap.get(parent),direction, child);
                treeMap.put(child, node);
            }

            if(command.equals("ask")){
                System.out.println(sumNumbers(tree.root));
            }
        }
    }
}
