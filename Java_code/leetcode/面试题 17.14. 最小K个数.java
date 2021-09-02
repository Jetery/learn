/*

设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]

*/


class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];

        // 排除 0 
        if (k == 0) return ret;
        // 要得到最小的k个数,建大堆,小于堆顶就出堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(o1,o2) -> o2 - o1);

        // for (int i = 0; i < arr.length; i++) {
        //     if (i < k) {
        //         heap.offer(arr[i]);
        //     } else {
        //         if (heap.peek() > arr[i]) {
        //             heap.poll();
        //             heap.offer(arr[i]);
        //         }
        //     }
        // }

        for (int i : arr){
            if (heap.size() < k) {
                heap.offer(i);
            } else {
                if (heap.peek() > i) {
                    heap.poll();
                    heap.offer(i);
                }
            }
        }

        int n = 0;
        while (!heap.isEmpty()) {
            ret[n++] = heap.poll();
        }
        return ret;
    }
}