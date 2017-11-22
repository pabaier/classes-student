import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Board {

    private final int[][] blocks;
    private final int n;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        n = blocks.length;
        this.blocks = new int[n][n];
        for (int r = 0; r < blocks.length; r++) {
            for (int c = 0; c < blocks[0].length; c++) {
                this.blocks[r][c] = blocks[r][c];
            }
        }
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of blocks out of place
    public int hamming() {
        int oop = 0;
        int shouldBe = 1;
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                 if (blocks[rows][cols] != shouldBe)
                    oop++;
                shouldBe++;
            }

        }
        return oop - 1;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int total = 0;
        int value = 0;
        int goalRow = 0;
        int goalCol = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                value = blocks[r][c];
                if (value == 0)
                    continue;
                goalRow = value / n;
                if (value % n == 0)
                    goalRow -= 1;
                goalCol = value % n - 1;
                if (goalCol < 0)
                    goalCol = n - 1;
                total += Math.abs(r - goalRow) + Math.abs(c - goalCol);
            }
        }

        return total;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] copy = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                copy[row][col] = blocks[row][col];
            }
        }

        if (copy[0][0] == 0) {
            int temp = copy[0][1];
            copy[0][1] = copy[n - 1][n - 1];
            copy[n - 1][n - 1] = temp;
        }
        else if (copy[n - 1][n - 1] == 0) {
            int temp = copy[0][0];
            copy[0][0] = copy[n - 1][n - 2];
            copy[n - 1][n - 2] = temp;
        }
        else {
            int temp = copy[0][0];
            copy[0][0] = copy[n - 1][n - 1];
            copy[n - 1][n - 1] = temp;
        }
        return new Board(copy);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board that = (Board) y;
        if (that.n != n)
            return false;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (blocks[r][c] != that.blocks[r][c])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> neigh = new Queue<>();
        // find empty space (0)
        int zr = 0;
        int zc = 0;
        for (int r = 0; r < n; r++) {
            boolean hit = false;
            for (int c = 0; c < n; c++) {
                if (blocks[r][c] == 0) {
                    zr = r;
                    zc = c;
                    hit = true;
                    break;
                }
            }
            if (hit)
                break;
        }
        
        // tl corner (2 boards)
        if (zr == 0 && zc == 0) {
            neigh.enqueue(swap(blocks, 0, 0, 0, 1));
            neigh.enqueue(swap(blocks, 0, 0, 1, 0));
        }
        // tr corner (2 boards)
        else if (zr == 0 && zc == n - 1) {
            neigh.enqueue(swap(blocks, zr, zc, 0, n - 2));
            neigh.enqueue(swap(blocks, zr, zc, 1, n - 1));

        }
        // bl corner (2 boards)
        else if (zr == n - 1 && zc == 0) {
            neigh.enqueue(swap(blocks, zr, zc, n - 2, 0));
            neigh.enqueue(swap(blocks, zr, zc, n - 1, 1));

        }
        // br corner (2 boards)
        else if (zr == n - 1 && zc == n - 1) {
            neigh.enqueue(swap(blocks, zr, zc, n - 2, n - 1));
            neigh.enqueue(swap(blocks, zr, zc, n - 1, n - 2));

        }
        // top edge (3 boards)
        else if (zr == 0) {
            neigh.enqueue(swap(blocks, zr, zc, 0, zc + 1));
            neigh.enqueue(swap(blocks, zr, zc, 0, zc - 1));
            neigh.enqueue(swap(blocks, zr, zc, 1, zc));

        }
        // left edge (3 boards)
        else if (zc == 0) {
            neigh.enqueue(swap(blocks, zr, zc, zr - 1, 0));
            neigh.enqueue(swap(blocks, zr, zc, zr + 1, 0));
            neigh.enqueue(swap(blocks, zr, zc, zr, 1));

        }
        // bottom edge (3 boards)
        else if (zr == n - 1) {
            neigh.enqueue(swap(blocks, zr, zc, zr, zc + 1));
            neigh.enqueue(swap(blocks, zr, zc, zr, zc - 1));
            neigh.enqueue(swap(blocks, zr, zc, zr - 1, zc));

        }
        // right edge (3 boards)
        else if (zc == n - 1) {
            neigh.enqueue(swap(blocks, zr, zc, zr + 1, zc));
            neigh.enqueue(swap(blocks, zr, zc, zr - 1, zc));
            neigh.enqueue(swap(blocks, zr, zc, zr, zc - 1));

        }
        //everywhere else (4 boards)
        else {
            neigh.enqueue(swap(blocks, zr, zc, zr + 1, zc));
            neigh.enqueue(swap(blocks, zr, zc, zr - 1, zc));
            neigh.enqueue(swap(blocks, zr, zc, zr, zc + 1));
            neigh.enqueue(swap(blocks, zr, zc, zr, zc - 1));
        }

        return neigh;
    }

    // swap the value at r1, c1 with that at r2, c2
    private Board swap(int[][] original, int r1, int c1, int r2, int c2) {
        Board b = new Board(original);
        int temp = b.blocks[r1][c1];
        b.blocks[r1][c1] = b.blocks[r2][c2];
        b.blocks[r2][c2] = temp;
        return b;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        String s = n + "\n";
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                s += blocks[r][c] + " ";
            }
            s += "\n";
        } 

        return s;

    }

    // unit tests (not graded)
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

        
        // neighbors test
        // *************************************************
        for(Board b : initial.neighbors())
            System.out.println(b + "\n");
        // *************************************************
        
        // manhattan test
        // *************************************************
            // System.out.println(initial);
            // System.out.println(initial.manhattan());
        // *************************************************

    }
}