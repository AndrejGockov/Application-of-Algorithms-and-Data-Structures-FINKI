//      Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M во листата и тој број да се помести k места на лево.
//
//      Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k.
//
//      Излез: На излез треба да се испечати листата пред и после промената.
//
//      For example:
//
//      Input:
//      5
//      1 2 3 4 5
//      3
//      2
//
//      Result:
//      1<->2<->3<->4<->5
//      3<->1<->2<->4<->5
//
//      Input:
//      9
//      5 3 8 6 2 4 1 9 7
//      4
//      7
//
//      Result:
//      5<->3<->8<->6<->2<->4<->1<->9<->7
//      5<->3<->8<->6<->2<->1<->9<->4<->7
//
//      Input:
//      10
//      1 2 3 4 5 6 7 8 9 10
//      11
//      7
//
//      Result:
//      1<->2<->3<->4<->5<->6<->7<->8<->9<->10
//      Elementot ne postoi vo listata
//      1<->2<->3<->4<->5<->6<->7<->8<->9<->10

import java.util.Scanner;

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void mirror() {

        DLLNode<E> tmp = null;
        DLLNode<E> current = first;
        last = first;
        while(current!=null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if(tmp!=null && tmp.pred!=null) {
            first=tmp.pred;
        }
    }
}

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

public class Main {
    public static DLL<Integer> setList(DLLNode<Integer>node){
        DLL<Integer> list = new DLL<Integer>();
        while(node != null){
            list.insertLast(node.element);
            node = node.succ;
        }
        return list;
    }

    public static void rotateLeftK(DLL<Integer> list, int n, int m, int k){
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
            rotateLeftK(list, n, m, k);
            return;
        }

        System.out.println(list);
    }
}