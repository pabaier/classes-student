public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int input = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }

        for (int i = 0; i < input; i++) {
            // StdOut.println(rq);
            StdOut.println(rq.dequeue());
        }
   }
}