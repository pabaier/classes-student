import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] values;
    private int n;
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        values = (Item[]) (new Object[1000]);
        n = 0;
    }

    // is the queue empty?
    public boolean isEmpty() { 
        return n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (n == values.length)
            resize(2*n);
         values[n] = item;
         n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0)
            throw new NoSuchElementException();

        if (n < values.length / 4 && n > 100)
            resize(values.length / 2);
        int random = (int) (StdRandom.uniform() * n);
        Item temp = values[random];
        values[random] = values[n - 1];
        n--;
        return temp;
        
    }
    
    // return (but do not remove) a random item
    public Item sample() {
        if (n == 0)
            throw new NoSuchElementException();

        int random = (int) (StdRandom.uniform() * n);
        return values[random];
    }

    private void resize(int x) {
        Item[] temp = (Item[]) (new Object[x]);
        for (int i = 0; i <= n; i++) {
            temp[i] = values[i];
        }
        values = temp;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (i == n)
                throw new NoSuchElementException();

            Item temp = values[i];
            i++;
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

        // RandomizedQueue<String> q = new RandomizedQueue<>();
        // q.enqueue("Hello, ");
        // q.enqueue("World! ");
        // q.enqueue("Luke ");
        // q.enqueue("I ");
        // q.enqueue("am ");
        // q.enqueue("your ");
        // q.enqueue("father ");

        // for(String s : q)
        //     StdOut.println(s);
        // StdOut.println(q.dequeue());
        // StdOut.println(q.sample());
        // StdOut.println(q.sample());
        // StdOut.println(q.sample());
         
    }
}