import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
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

    private ArrayList<Board> solution;
    private final boolean solvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();

        solution = new ArrayList<>();
        Node first = new Node(initial, null);
        Node firstB = new Node(initial.twin(), null);
        MinPQ<Node> pq = new MinPQ<>();
        MinPQ<Node> pqB = new MinPQ<>();
        pq.insert(first);
        pqB.insert(firstB);
        solution.add(pq.min().board);

        while (!pq.min().board.isGoal() && !pqB.min().board.isGoal()) {
            // delete minimum node
            Node temp = pq.delMin();
            Node tempB = pqB.delMin();
            
            // get neighboring boards
            ArrayList<Board> next = new ArrayList<>(); 
            ArrayList<Board> nextB = new ArrayList<>(); 
            next = (ArrayList<Board>) temp.board.neighbors();
            nextB = (ArrayList<Board>) tempB.board.neighbors();

            // add neighboring boards that are not the previous board
            for (Board a : next) {
                if (temp.previous == null)
                    pq.insert(new Node(a, temp));
                else if (!a.equals(temp.previous.board))
                    pq.insert(new Node(a, temp));
            }

            for (Board b : nextB) {
                if (tempB.previous == null)
                    pqB.insert(new Node(b, tempB));
                else if (!b.equals(tempB.previous.board))
                    pqB.insert(new Node(b, tempB));
            }

            // add minimum to the solution
            solution.add(pq.min().board);

            // testing
            // for(Node n : pq) {
            //     System.out.println(n.board + "\t" + n.moves + ", " + n.priority + "\n");
            // }
            //     System.out.println("---------------------------");
            // StdIn.readLine();
            // end tests
        
        }

        solvable = pq.min().board.isGoal();
    } 

    // is the initial board solvable?
    public boolean isSolvable() {
        return solvable;
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

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}