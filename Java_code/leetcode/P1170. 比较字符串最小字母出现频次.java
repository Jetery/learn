class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] count = new int[words.length];
        for(int i = 0; i < words.length; i++){
            count[i] = f(words[i]);
        }
        Arrays.sort(count);
        for(int i = 0; i < queries.length; i++) {
            int qCount = f(queries[i]);
            int resValue = 0;
            for (int j = 0; j < words.length; j++) {
                if (count[j] > qCount) {
                    resValue =  words.length - j;
                    break;
                }
            }
            res[i] = resValue;
        }
        return res;
    }

    private int f(String str) {
        //第一个字母出现一次
        char c = str.charAt(0);
        int ret = 1;

        for (int i = 1; i < str.length(); i++) {
            //相同说明仍然是目前最小字母
            if (str.charAt(i) == c) ret++;

            //更新  并且  重置
            if (str.charAt(i) < c){
                c = str.charAt(i);
                ret = 1;
            }
        }
        return ret;
    }
}