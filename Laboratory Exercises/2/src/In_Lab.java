//        Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M во листата и тој број да се помести k места на лево.
//
//        Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k.
//
//        Излез: На излез треба да се испечати листата пред и после промената.
//        For example:
//        Input:
//        5
//        1 2 3 4 5
//        3
//        2
//
//        Result:
//        1<->2<->3<->4<->5
//        3<->1<->2<->4<->5
//
//        Input:
//        9
//        5 3 8 6 2 4 1 9 7
//        4
//        7
//
//        Result:
//        5<->3<->8<->6<->2<->4<->1<->9<->7
//        5<->3<->8<->6<->2<->1<->9<->4<->7
//
//        Input:
//        10
//        1 2 3 4 5 6 7 8 9 10
//        11
//        7
//
//        Result:
//        1<->2<->3<->4<->5<->6<->7<->8<->9<->10
//        Elementot ne postoi vo listata
//        1<->2<->3<->4<->5<->6<->7<->8<->9<->10


import java.util.Scanner;

public class In_Lab {
    public static DLL<Integer> setList(DLLNode<Integer>node){
        DLL<Integer> list = new DLL<Integer>();
        while(node != null){
            list.insertLast(node.element);
            node = node.succ;
        }
        return list;
    }

    public static void rotateRightK(DLL<Integer> list, int n, int m, int k){
        DLLNode<Integer>node = list.getFirst();
        DLL<Integer> newList = new DLL<Integer>();

        // 1. Itterates through all the elements in the current node
        // 2. When it finds m it deletes the last element in the list and places m,
        // after which it places the previous last element in the back of the list
        // 3. If the previous node is null it waits to place every other element in first,
        // then places m in the back
        // 4. Set node to newList.getFirst()
        // 5. Set list to newList by using setList(node) function
        for(int i = 0; i < k; i++){
            newList = new DLL<Integer>();
            boolean previousNull = false;
            while(node != null){
                if(node.element == m){
                    if(node.pred == null){
                        previousNull = true;
                    }else{
                        newList.deleteLast();
                        newList.insertLast(m);
                        newList.insertLast(node.pred.element);
                    }

                    node = node.succ;
                    continue;
                }

                newList.insertLast(node.element);
                node = node.succ;
            }
            if(previousNull && newList.getSize() < n)
                newList.insertLast(m);

            node = newList.getFirst();
            list = setList(node);
            newList = new DLL<Integer>();
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for(int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        int m = input.nextInt();
        int k = input.nextInt();

        System.out.println(list);

        if(list.find(m) != null){
            rotateRightK(list, n, m, k);
            return;
        }

        System.out.println(list);
    }
}