/*

链接：https://www.nowcoder.com/questionTerminal/89844f1f632c475ab6f4a600f71683a8?orderByHotValue=1&questionTypes=100111&commentTags=C/C++
来源：牛客网

We are all familiar with pre-order, in-order and post-order traversals of binary trees. 
A common problem in data structure classes is to find the pre-order traversal of a binary tree when given the in-order and post-order traversals. 
Alternatively, you can find the post-order traversal when given the in-order and pre-order. 
However, in general you cannot determine the in-order traversal of a tree when given its pre-order and post-order traversals. 


All of these trees have the same pre-order and post-order traversals. 
This phenomenon is not restricted to binary trees, but holds for general m-ary trees as well.

输入描述:
Input will consist of multiple problem instances. 
Each instance will consist of a line of the form m s1 s2, indicating that the trees are m-ary trees, s1 is the pre-order traversal and s2 is the post-order traversal.
All traversal strings will consist of lowercase alphabetic characters. 
For all input instances, 1 <= m <= 20 and the length of s1 and s2 will be between 1 and 26 inclusive. 
If the length of s1 is k (which is the same as the length of s2, of course), the first k letters of the alphabet will be used in the strings. 
An input line of 0 will terminate the input.


输出描述:
For each problem instance, you should output one line containing the number of possible trees which would result in the pre-order and post-order traversals for the instance. 
All output values will be within the range of a 32-bit signed integer. 
For each problem instance, you are guaranteed that there is at least one tree with the given pre-order and post-order traversals.

示例1
	输入
		2 abc cba
		2 abc bca
		10 abc bca
		13 abejkcfghid jkebfghicda
	输出
		4
		1
		45
		207352860

*/

import java.util.HashSet;
import java.util.Scanner;
public class Main {
   private static long num = 1;
   private static long[] numArr;

   public static void main(String[] args){
       numArr = new long[21];
       numArr[0] = 1;
       for (int i = 1; i < 21; i++) {
           numArr[i] = numArr[i - 1] * i;
       }
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()) {
           int n = sc.nextInt();
           String preOrder = sc.next();
           String postOrder = sc.next();
           num = 1;
           CalculateTree(n, preOrder, postOrder);
           System.out.println(num);
       }
   }

   private static void CalculateTree(int n, String preOrder, String postOrder) {
       int len = preOrder.length();
       if (len == 1) {
           return;
       }
       int count = 0;
       preOrder = preOrder.substring(1);
       postOrder = postOrder.substring(0, len-1);
       while (!"".equals(preOrder)) {
           int index = postOrder.indexOf(preOrder.charAt(0))+1;
           String newPre = preOrder.substring(0, index);
           String newPost = postOrder.substring(0, index);
           preOrder = preOrder.substring(index);
           postOrder = postOrder.substring(index);
           count++;
           CalculateTree(n, newPre, newPost);
       }
       num *= CalculateCom(count, n);
   }

   private static long CalculateCom(int subNum, int n) {
       return numArr[n] / (numArr[n - subNum] * numArr[subNum]);
   }
}
