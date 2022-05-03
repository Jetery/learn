package classCode;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.04.30
 */
public class UnionMax {
    private int[] arr;
    private int[] max;
    private int[] size;

    public UnionMax(int n) {
        this.arr = new int[n];
        this.max = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            max[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (arr[i] != i) {
            i = arr[arr[i]];
        }
        return i;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        int temp = Math.max(p, q);
        max[i] = temp;
        max[j] = temp;
        if (i == j) {
            return ;
        }
        if (size[i] < size[j]) {
            arr[i] = j;
            size[j] += size[i];
        } else {
            arr[j] = i;
            size[i] += size[j];
        }
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    public int find(int i) {
        return max[root(i)];
    }

    public static void main(String[] args) {
        UnionMax test = new UnionMax(10);
        test.union(1,3);
        test.union(3,5);
        System.out.println(test.find(1));
        System.out.println(test.find(3));
        test.union(5, 9);
        System.out.println(test.find(1));
        System.out.println(test.connected(1, 9));
        System.out.println(test.connected(1, 4));
    }
}
