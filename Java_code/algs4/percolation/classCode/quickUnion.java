package classCode;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.04.24
 */

public class quickUnion {

    private int[] arr;

    public quickUnion(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }
    private int root (int i) {
        while (arr[i] != i) i = arr[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        arr[rootP] = rootQ;
    }

}


