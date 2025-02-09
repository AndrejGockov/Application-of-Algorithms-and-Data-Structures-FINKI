package Trees;

import java.util.*;

public class Sum_Of_Left_Children {
    public static int leftSum(BNode<Integer>node){
        if(node == null)
            return 0;

        int sum = 0;

        if(node.left != null && node.right == null){
            sum += node.info;
        }

        sum += + leftSum(node.left) + leftSum(node.right);

        return sum;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BTree<Integer>tree = new BTree<>();
        HashMap<Integer, BNode<Integer>>treeMap = new HashMap<>();

        for(int i = 0; i < n; i++){
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

                BNode<Integer>node = tree.addChild(treeMap.get(parent), direction, child);
                treeMap.put(child,node);
            }

            if(command.equals("ask")){
                BNode<Integer>node = treeMap.get(input.nextInt());
                System.out.println(leftSum(node));
            }
        }
    }
}
