import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] percolates;
    private final double meanValue;
    private final double stddevValue;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();

        percolates = new double[trials];

        for (int i = 0; i < trials; i++) {
            
            Percolation p = new Percolation(n);              // new percolation for every trial
            
            // need to open squares one by one - there are n*n squares
            for (int j = 0; j < n * n; j++) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);

                while (p.isOpen(row, col)) {
                    row = StdRandom.uniform(1, n + 1);
                    col = StdRandom.uniform(1, n + 1);
                }

                p.open(row, col);

                if (p.percolates()) {
                    break;
                }
            }

            percolates[i] = p.numberOfOpenSites()/(double) (n*n);
        }
        meanValue = StdStats.mean(percolates);
        stddevValue = StdStats.stddev(percolates);

    }

    // sample mean of percolation threshold
    public double mean() {
        return meanValue;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddevValue;
    }
    
    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96*stddevValue/Math.sqrt(percolates.length));
    }
    
    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96*stddevValue/Math.sqrt(percolates.length));
    }

    // test client (described below)
    public static void main(String[] args) {

        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);

        PercolationStats p = new PercolationStats(i, j);

        StdOut.println("mean\t\t\t= " + p.mean());
        StdOut.println("stddev\t\t\t= " + p.stddev());
        StdOut.println("95% confidence interval = [" + 
                        p.confidenceLo() + ", " + p.confidenceHi() +"]");
    }
}