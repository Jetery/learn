package src;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.05.01
 */
public class PercolationStats {

    private double[] results;
    private final double mean;
    private final double stddev;
    private final double high;
    private final double low;
    private Percolation percolation;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        results = new double[trials];
        for (int t = 0; t < trials; t++) {
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int x = StdRandom.uniform(n) + 1;
                int y = StdRandom.uniform(n) + 1;
                while (percolation.isOpen(x, y)) {
                    x = StdRandom.uniform(n) + 1;
                    y = StdRandom.uniform(n) + 1;
                }
                //System.out.println(x + "  " + y);
                percolation.open(x, y);
            }
            results[t] = percolation.numberOfOpenSites() / (n * n * 1.0);
            // release the memory
            percolation = null;

        }
        this.mean = StdStats.mean(results);
        this.stddev = StdStats.stddev(results);
        this.low = mean - 1.96 * stddev / Math.sqrt(trials);
        this.high = mean + 1.96 * stddev / Math.sqrt(trials);

    }

    // sample mean of percolation threshold
    public double mean() {
        return this.mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return this.stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.low;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.high;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

}