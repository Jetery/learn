package classCode;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.05.01
 */
public class Successor {

    private int[] num;
    private int[] map;
    private int[] size;

    public Successor(int n) {
        num = new int[n];
        map = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i;
            map[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (num[i] != i) {
            i = num[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return ;
        if (size[i] < size[j]) {
            num[i] = j;
            size[j] += size[i];
        } else {
            num[j] = i;
            size[i] += size[j];
            map[i] = j;
        }
    }

    public void remove(int i) {
        union(i, i + 1);
    }

    public int find(int i) {
        return map[root(i + 1)];
    }

    public static void main(String[] args) {
        Successor successor = new Successor(10);
        successor.remove(7);
        System.out.println(successor.find(7));
        successor.remove(8);
        System.out.println(successor.find(7));
    }
}
