class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for(int[] arr : ops) {
            m = Math.min(m, arr[0]);
            n = Math.min(n, arr[1]);
        }
        return m * n;
    }
}