import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Comparator;


public class Solver {

    private class Node implements Comparable<Node>{
        private Board board;
        private Node previous;
        private int moves;
        private int manhattan;
        private int priority;

        Node(Board b, Node p) {
            board = b;
            previous = p;
            if (previous == null)
                moves = 0;
            else
                moves = previous.moves + 1;
            manhattan = board.manhattan();
            priority = moves + manhattan;
        }

        public int compareTo(Node that) {
            int pri = this.priority - that.priority;
            // if (pri == 0)
            //     return that.moves - this.moves; // return this.board.hamming() - that.board.hamming();
            return pri;
        }

        public Comparator<Node> hammingOrder() {
            Comparator<Node> m = new ByHamming();
            return m;
        }
    
        private class ByHamming implements Comparator<Node> {
            public int compare(Node a, Node that) {
                return a.board.hamming() - that.board.hamming();
            }
        }

        public Comparator<Node> manhattanOrder() {
            Comparator<Node> m = new ByManhattan();
            return m;
        }

        private class ByManhattan implements Comparator<Node> {
            public int compare(Node a, Node that) {
                return a.manhattan - that.manhattan;
            }
        }
    }

    MinPQ<Node> pq;
    ArrayList<Board> solution;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();

        solution = new ArrayList<>();
        Node first = new Node(initial, null);
        pq = new MinPQ<>();
        pq.insert(first);
        solution.add(pq.min().board);

        while (!pq.min().board.isGoal()) {
            Node temp = pq.delMin();
            ArrayList<Board> next = new ArrayList<>(); 
            next = (ArrayList<Board>) temp.board.neighbors();
            for (Board b : next) {
                if (temp.previous == null)
                    pq.insert(new Node(b, temp));
                else if (!b.equals(temp.previous.board))
                    pq.insert(new Node(b, temp));
            }
            solution.add(pq.min().board);
        
        // testing
            // for(Node n : pq) {
            //     System.out.println(n.board + "\t" + n.moves + ", " + n.priority + "\n");
            // }
            //     System.out.println("---------------------------");
            // StdIn.readLine();
        // end tests
        
        }

        // prints solutions from solution arrylist
        for (Board n : solution)
            System.out.println(n + "\n");
    } 

    // is the initial board solvable?
    public boolean isSolvable() {
        MinPQ<Node> pqA = new MinPQ<>();
        MinPQ<Node> pqB = new MinPQ<>();
        pqA.insert(new Node(init, null));
        pqB.insert(new Node(init.twin(), null));



        return true;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable())
            return -1;
        return solution.size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable())
            return null;
        return solution;
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
       
        // System.out.println(initial + "\n");

        // solve the puzzle
        Solver solver = new Solver(initial);
    }
}