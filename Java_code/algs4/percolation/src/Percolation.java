package src;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.05.01
 */
public class Percolation {

    // n to get the size of grid
    private int n;
    private int count = 0;
    private boolean[][] grid;
    private WeightedQuickUnionUF union;
    // to avoid the percolated bottom go back to the aimed cell
    private WeightedQuickUnionUF fullState;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) throw new java.lang.IllegalArgumentException();
        this.n = n;
        this.grid = new boolean[n][n];
        union = new WeightedQuickUnionUF(n * n + 2);
        fullState = new WeightedQuickUnionUF(n * n + 1);
    }

    private void check(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    private int getIndex(int row, int col) {
        check(row, col);
        return (row - 1) * n + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        check(row, col);
        if (!grid[row - 1][col - 1]) {
            count++;
            grid[row - 1][col - 1] = true;

            int index = getIndex(row, col);
            // connect to the top
            if (row == 1) {
                union.union(0, index);
                fullState.union(0, index);
            }
            // connect to the bottom
            if (row == n) {
                union.union(index, n * n + 1);
            }
            // above
            if (row > 1 && isOpen(row - 1, col)) {
                union.union(index, index - n);
                fullState.union(index, index - n);
            }
            // below
            if (row < this.n && isOpen(row + 1, col)) {
                union.union(index, index + n);
                fullState.union(index, index + n);
            }
            // left
            if (col > 1 && isOpen(row, col - 1)) {
                union.union(index, index - 1);
                fullState.union(index, index - 1);
            }
            // right
            if (col < this.n && isOpen(row, col + 1)) {
                union.union(index, index + 1);
                fullState.union(index, index + 1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        check(row, col);
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        check(row, col);
        if(!isOpen(row,col)) return false;
        return fullState.find(getIndex(row, col)) == fullState.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.count;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(n * n + 1) == union.find(0);
    }

    // test client (optional)
    public static void main(String[] args) {
        // Percolation test = new Percolation(3);
        // test.open(1,3);
        // test.open(2,3);
        // test.open(3,3);
        // test.open(3,1);
        // System.out.println(test.isFull(3, 1));
    }
}
