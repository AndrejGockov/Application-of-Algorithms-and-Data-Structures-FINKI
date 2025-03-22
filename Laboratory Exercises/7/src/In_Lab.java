import java.util.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

public class In_Lab {

    public static int countTwoChildren(BNode<String>node){
        // If the node is null return 0
        if(node == null)
            return 0;

        int count = 0;

        // If both children exist count++
        if(node.left != null && node.right != null)
            count++;

        // Check for both children and add to count
        if(node.left != null)
            count += countTwoChildren(node.left);

        if(node.right != null)
            count += countTwoChildren(node.right);

        // count += countTwoChildren(node.left) + countTwoChildren(node.right);

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();

        BTree<String>tree = new BTree<>();
        Map<String, BNode<String>> nodesHashMap = new HashMap<>();

        for(int i = 0; i < n + q; i++) {
            String command = input.next();

            if(command.equals("root")) {
                String rootName = input.next();
                tree.makeRoot(rootName);
                nodesHashMap.put(rootName, tree.root);
            }

            if(command.equals("add")){
                String parentString = input.next();
                String childString = input.next();
                String directionString = input.next();

                BNode<String> parent = nodesHashMap.get(parentString);
                int direction = directionString.equals("LEFT") ? BNode.LEFT : BNode.RIGHT;
                BNode<String> addNode = tree.addChild(parent, direction, childString);

                nodesHashMap.put(childString, addNode);
            }

            if(command.equals("ask")){
                String nodeString = input.next();
                BNode<String> foundNode = nodesHashMap.get(nodeString);
                System.out.println(countTwoChildren(foundNode));
            }
        }
    }
}