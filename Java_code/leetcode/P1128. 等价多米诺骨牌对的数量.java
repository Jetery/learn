/*


给你一个由一些多米诺骨牌组成的列表 dominoes。

如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。

形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。

在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。


*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int[] arr : dominoes){
            Arrays.sort(arr);
            int num = arr[0] * 10 + arr[1];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //  使用 foreach
        /*
        for (int key : map.keySet()){
            int n = map.get(key);
            ans += (n * (n - 1)) / 2;
        }
        */

        //  使用 迭代器 iterator
        /*
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer, Integer> entry = iter.next();
            int n = entry.getValue();
            ans += (n * (n - 1)) / 2;
        }
        
        // [ALSO]
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int n = entry.getValue();
        //     ans += (n * (n - 1)) / 2;
        // }
        
        */
        return ans;
    }
}