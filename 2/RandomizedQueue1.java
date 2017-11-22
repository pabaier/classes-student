import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        first = new Node();
        size = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;

    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node temp = first;
        first = new Node();
        first.value = item;
        first.next = temp;

        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException();
        int random = (int) (StdRandom.uniform() * size);
        if (random == 0) {
            Item temp = first.value;
            first = first.next;
            size--;
            return temp;
        }
        else {
            Node previous = first;
            Node current = first.next;
            Node after = current.next;
            for (int i = 1; i < random; i++) {
                previous = current;
                current = after;
                after = after.next;
            }
            previous.next = current.next;

            size--;
            return current.value;
        }
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException();
        int random = (int) (StdRandom.uniform() * size);
        Node tempNode = first;
        for (int i = 0; i < random; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new MyRandomIterator();
    }

    // public String toString() {
    //     String s = "[";
    //     Node temp = first;
    //     for(int i = 0; i < size; i++) {
    //         s += temp.value + " ";
    //         temp = temp.next;
    //     }
    //     s += "]";
    //     return s;
    // }

    private class Node {
        private Item value;
        private Node next;

        // public String toString() {
        //     return "Value: " + value;
        // }
    }

    private class MyRandomIterator implements Iterator<Item> {
        private Node start = first;
        
        public boolean hasNext() {
            return start.next != null;
        }

        public Item next() {
            if (start == null)
                throw new NoSuchElementException();
            Item temp = start.value;
            start = start.next;
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
        // RandomizedQueue<String> r = new RandomizedQueue<>();
        // r.enqueue("Hello");
        // r.enqueue("This");
        // r.enqueue("Works!");
        // StdOut.println(r);
        // StdOut.println(r);
        // for(String i : r) {
        //     StdOut.println(i);
        // }
    }
}