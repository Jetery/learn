/*

星际战争开展了100年之后，

NowCoder终于破译了外星人的密码！

他们的密码是一串整数，通过一张表里的信息映射成最终4位密码。

表的规则是：
    n对应的值是矩阵X的n次方的左上角，如果这个数不足4位则用0填充，如果大于4位的则只输出最后4位。
|1 1|^n => |Xn ..|
|1 0|      |.. ..|
例如n=2时，
|1 1|^2 => |1 1| * |1 1| => |2 1|
|1 0|      |1 0|   |1 0|    |1 1|
即2对应的数是“0002”。

*/
import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int[] fib = new int[10001];
       fib[1] = 1;
       fib[2] = 2;
       for (int i = 3; i < 10001; i++){
           fib[i] = (fib[i - 1] + fib[i - 2]) % 10000;
       }

       while (sc.hasNext()){
           int n = sc.nextInt();
           int[] arr = new int[n];
           for(int i = 0; i < n; i++) {
               arr[i] = sc.nextInt();
           }

           for (int num : arr){
               help(fib[num]);
           }
           System.out.println();
       }
   }

   private static void help(int n){
       String s = "";
       s += n;
       int len = s.length();
       if (len == 4){
           System.out.print(s);
       } else if (len > 4){
           String sub = s.substring(len - 4, len);
       } else {
           for (int i = 0; i < 4 - len; i++){
               System.out.print("0");
           }
           System.out.print(s);
       }
   }
}

