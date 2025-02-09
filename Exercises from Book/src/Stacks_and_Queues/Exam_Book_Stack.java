package Stacks_and_Queues;

import java.util.*;

public class Exam_Book_Stack {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        // For maintaining original order of the books
        String[] originalStack = new String[n];
        Stack<String>bookStack = new Stack<>();
        Hashtable<String, Integer>hash = new Hashtable<>();

        for (int i = 0; i < n; i++){
            originalStack[i] = input.next();
            bookStack.push(originalStack[i]);
            hash.put(originalStack[i], 0);
        }

        for(int i = 0; i < m; i++){
            String bookNeeded = input.next();
            Stack<String>bookTracker = new Stack<>();

            // Goes through the books until it finds the needed one
            while(!bookNeeded.equals(bookStack.peek())){
                String currBook = bookStack.pop();
                bookTracker.push(currBook);
                hash.put(currBook, hash.get(currBook) + 1);
            }

            // Pushes book to the top of the pile, and updates it being picked up
            bookStack.pop();
            hash.put(bookNeeded, hash.get(bookNeeded) + 1);

            // Updates the book stack
            while(!bookTracker.isEmpty())
                bookStack.push(bookTracker.pop());

            bookStack.push(bookNeeded);
        }

        // Prints result in the original order
        for(String book : originalStack)
            System.out.println(book + " " + hash.get(book));
    }
}