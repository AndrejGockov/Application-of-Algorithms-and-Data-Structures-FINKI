//        Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку јазли со точно две деца има во поддрвото на избран јазол“.
//        Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.
//
//        Влезот ќе содржи N+Q редови од видот
//        root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
//        add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
//        ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
//
//        Пример и структура на влезот:
//        Влез:
//        11 9
//        root bravo
//        add bravo echo LEFT
//        add echo beard LEFT
//        ask beard
//        ask bravo
//        add bravo foxtrot RIGHT
//        add beard hotel LEFT
//        add beard india RIGHT
//        ask echo
//        add foxtrot golf LEFT
//        add golf juliet RIGHT
//        add india sierra RIGHT
//        ask foxtrot
//        ask bravo
//        ask beard
//        add echo mike RIGHT
//        add foxtrot tango RIGHT
//        ask echo
//        ask bravo
//        ask foxtrot
//
//        Излез:
//        0
//        0
//        1
//        0
//        2
//        1
//        2
//        4
//        1
//
//        Објаснување:
//        Прикажано е изгледот на дрвото при секоја од 4те групи прашања во влезот

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLLTree<E> implements Tree<E> {

    // SLLNode is the implementation of the Node interface
    public static class SLLNode<P> implements Node<P> {

        // Holds the links to the needed nodes
        SLLNode<P> parent, sibling, firstChild;

        // Hold the data
        P element;

        public SLLNode(P o) {
            element = o;
            parent = sibling = firstChild = null;
        }

        public P getElement() {
            return element;
        }

        public void setElement(P o) {
            element = o;
        }

    }

    protected SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list
                // and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator implements Iterator<E> {

        SLLNode<E> start, current;

        public SLLTreeIterator(SLLNode<E> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<E> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator(((SLLNode<E>) node).firstChild);
    }


    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i = 0; i < level; i++)
            System.out.print("  ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>) node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level + 1);
            tmp = tmp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

    public int countMaxChildren() {
        return countMaxChildrenRecursive(root);
    }

    int countMaxChildrenRecursive(SLLNode<E> node) {
        int t = childCount(node);
        SLLNode<E> tmp = node.firstChild;
        while (tmp != null) {
            t = Math.max(t, countMaxChildrenRecursive(tmp));
            tmp = tmp.sibling;
        }
        return t;
    }


    @Override
    public Iterable<Node<E>> childrenNodes(Node<E> node) {
        return new NodeIterable(((SLLNode<E>)node).firstChild);
    }

    public class NodeIterable implements Iterable<Node<E>>{

        Node<E> start;
        public NodeIterable(Node<E> start) {
            this.start = start;
        }

        @Override
        public Iterator<Node<E>> iterator() {
            return new NodeIterator(start);
        }
    }

    public class NodeIterator implements Iterator<Node<E>> {
        Node<E> current;

        public NodeIterator(Node<E> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<E> next() {
            Node<E> rez = current;
            current = ((SLLNode<E>) current).sibling;
            return rez;
        }
    }
}