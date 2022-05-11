import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private int openSites;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
            
        grid = new boolean[n][n];
        // Plus two for virtual sites
        uf = new WeightedQuickUnionUF(n*n + 2);
        openSites = 0;

        // populate grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }
    
    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        row = row - 1;
        col = col - 1;
        if (row >= grid.length || col >= grid.length || row < 0 || col < 0)
            throw new IllegalArgumentException();

        if (!grid[row][col]) {
            grid[row][col] = true;
            int space = gridToUF(row, col);
            int connect;
            openSites++;
           
            // look up
            if (row > 0 && grid[row - 1][col]) {
                connect = gridToUF(row - 1, col);
                uf.union(space, connect);
            }

             // look down
            if (row < grid.length - 1 && grid[row + 1][col]) {
                connect = gridToUF(row + 1, col);
                uf.union(space, connect);
            }

             // look left
            if (col > 0 && grid[row][col - 1]) {
                connect = gridToUF(row, col - 1);
                uf.union(space, connect);
            }

            // look right
            if (col < grid.length - 1 && grid[row][col + 1]) {
                connect = gridToUF(row, col + 1);
                uf.union(space, connect);
            }

            // connect top row to virtual top
            if (row == 0) {
                connect = gridToUF(0, col);
                uf.union(grid.length * grid.length, connect);
            }
            
            // connect bottom row to virtual bottom

            // connect bottom row to virtual bottom
            // only if the location itself is full
            if (isFull(row + 1, col + 1)) {
                for (int i = 1; i <= grid.length; i++) {
                    if (grid[grid.length - 1][i - 1]) {
                        if (isFull(grid.length, i)) {
                            connect = gridToUF(grid.length - 1, i - 1);
                            uf.union(grid.length * grid.length + 1, connect);
                        }
                    }
                }
            }


            
        }
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        row = row - 1;
        col = col - 1;
        if (row >= grid.length || col >= grid.length || row < 0 || col < 0)
            throw new IllegalArgumentException();

        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        row = row - 1;
        col = col - 1;
        if (row >= grid.length || col >= grid.length || row < 0 || col < 0)
            throw new IllegalArgumentException();

        int connect = gridToUF(row, col);
        return uf.connected(grid.length*grid.length, connect);
    }
    
    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }
    
    // does the system percolate?
    public boolean percolates() {
        int top = grid.length * grid.length;
        return uf.connected(top, top + 1);
    }

    // prints the grid
    private void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                StdOut.print(grid[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
    }

    // converts the grid coordinates to union find array indecies
    private int gridToUF(int row, int col) {
        int n = grid.length;
        return row * n + col;
    }
    
    // test client (optional)
    public static void main(String[] args) {
        // int i = Integer.parseInt(args[0]);

        Percolation p = new Percolation(2);
        p.printGrid();
    }

}