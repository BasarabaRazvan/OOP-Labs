import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class LinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    class ListIterator implements Iterator<T> {
        Node<T> current;

        public ListIterator(LinkedList<T> current) {
            this.current = current.first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.value;
            current = current.next;
            return data;
        }
    }

    Node<T> first, last;

    public void addFirst(T data) {
        if(first == null) {
            first = new Node<T>(data);
            last = first;
        } else {
            Node nod = new Node<T>(data);
            nod.next = first;
            first = nod;
        }
    }

    public void add(T data) {
        if(first == null) {
            first = new Node<T>(data);
            last = first;
        } else {
            Node nod = new Node<T>(data);
            last.next = nod;
            last = nod;
        }
    }

    public T getNode() {
        return (T) first.value;
    }

    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

}

class Task3 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.add(22);
        list.add(25);
        list.add(30);

        int last = 0;
        System.out.println("Afisare 1");
        for (Integer i : list) {
            System.out.print(i + ", ");
            if (i < last) {
                System.err.println("LinkedList a fost implementata gresit.");
            }
            last = i;
        }
        System.out.println();

        System.out.println("Afisare 2");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
    }
}