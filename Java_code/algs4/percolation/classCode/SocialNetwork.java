package classCode;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.04.30
 */
public class SocialNetwork {

    private int[] member;
    private int[] size;
    private int[][] timestamps;
    private int count;

    public SocialNetwork(int n, int m) {
        this.count = n;
        this.member = new int[n];
        this.size = new int[n];
        for (int i = 0; i < member.length; i++) {
            member[i] = i;
            size[i] = 1;
        }
        this.timestamps = new int[m][2];
    }

    private int root (int n) {
        while (member[n] != n) {
            member[n] = member[member[n]];
            n = member[n];
        }
        return n;
    }

    public void readTimeStamp(int[][] timeStamps) {
        for (int[] timeStamp : timeStamps) {
            union(timeStamp[0], timeStamp[1]);
        }
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            member[i] = j;
            size[j] += size[i];
        } else {
            member[j] = i;
            size[i] += size[j];
        }
        if (count > 1) count--;
        if (count == 1) System.out.println("all members are connected.");
    }

    public static void main(String[] args) {
        int[][] arrs = new int[][] {
                {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 0}
        };
        SocialNetwork test = new SocialNetwork(10, arrs.length);
        for (int i = 0; i < arrs.length; i++) {
            test.timestamps[i][0] = arrs[i][0];
            test.timestamps[i][1] = arrs[i][1];
        }
        test.readTimeStamp(test.timestamps);
    }



}
