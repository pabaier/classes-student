import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node front, back;
    private int size;

    // construct an empty deque
    public Deque() {
        front = new Node();
        back = new Node();
        front.previous = back;
        back.next = front;
        
        front.next = null;
        back.previous = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        front.value = item;
        Node temp = front;
        front = new Node();
        temp.next = front;
        front.next = null;
        front.previous = temp;
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        back.value = item;
        Node temp = back;
        back = new Node();
        temp.previous = back;
        back.next = temp;
        back.previous = null;
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();

        Item temp = front.previous.value;
        front = front.previous;
        front.next = null;
        size--;
        return temp;

    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0)
            throw new NoSuchElementException();

        Item temp = back.next.value;
        back = back.next;
        back.previous = null;
        size--;
        return temp;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new MyDeckIterator();
    }

    private class Node {
        private Item value;
        private Node next;
        private Node previous;
    }

    private class MyDeckIterator implements Iterator<Item> {

        private Node current = front; 

        public boolean hasNext() {
            return current.previous.previous != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Item currentValue = current.previous.value;
            current = current.previous;
            return currentValue;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> d = new Deque<>();
        d.addFirst("Hello, ");
        d.addFirst("World!");
        d.addLast(" This");
        d.addLast(" is");
        d.addFirst(" it!");

        for (String s : d)
            StdOut.println(s);
    }
}