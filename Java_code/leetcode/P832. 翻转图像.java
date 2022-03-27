/*

给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 

示例 1：

输入：[[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

示例 2：

输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]


*/



//  violence
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverse(0, image[i].length - 1, image[i]);
        }
        for(int[] arr : image){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] ^= 1;
                } else {
                    arr[i] ^= 1;
                }
            }
        }
        return image;
    }
     private void reverse (int l, int r, int[] arr){
         while (r > l) {
             int temp = arr[l];
             arr[l++] = arr[r];
             arr[r--] = temp;
         }
     }
}



// 遍历一次
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverse(0, image[i].length - 1, image[i]);
        }
        return image;
    }
     private void reverse (int l, int r, int[] arr){
         while (r >= l) {
             if (l == r) {
                 arr[l] ^= 1;
                 break;
             }
             if (arr[l] == arr[r]) {
                 arr[l] ^= 1;
                 arr[r] ^= 1;
             }
             l++;
             r--;
         }
     }
}