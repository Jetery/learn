package classCode;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.04.30
 */

//  the upper case may make the tree too high
public class quickUnion2 {

    private int[] arr;
    private int[] size;
    public quickUnion2(int n) {
        this.arr = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (arr[i] != i) {
            // this will make the tree more flat
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        //  p and q have the same root
        if (i == j) return ;
        if (size[i] > size[j]) {
            arr[j] = i;
            size[i] += size[j];
        } else {
            arr[i] = j;
            size[j] += size[i];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        quickUnion2 test = new quickUnion2(10);
        test.union(1,2);
    }

}