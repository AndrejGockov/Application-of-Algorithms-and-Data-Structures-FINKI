package Trees;

import java.util.*;

public class Is_Tree_SumTree {
    public static boolean isSumTree(BNode<Integer>node){
        if(node == null)
            return false;

        if(node.left != null && node.right != null){
            int sum = node.left.info + node.right.info;
            if(node.info == sum)
                return true;
        }

        return isSumTree(node.left) || isSumTree(node.right);
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        BTree<Integer>tree = new BTree<>();
        HashMap<Integer, BNode<Integer>>treeMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String command = input.next();

            if(command.equals("root")){
                tree.makeRoot(input.nextInt());
                treeMap.put(tree.root.info, tree.root);
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
                if(isSumTree(tree.root)){
                    System.out.println("The given tree is a SumTree");
                }else{
                    System.out.println("The given tree isn't a SumTree");
                }
            }
        }
    }
}
