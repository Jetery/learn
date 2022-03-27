//
// 有一对兔子, 从出生后第 3 个月起每个月都生一对兔子,
//
// 小兔子长到第三个月后每个月又生一对兔子,
//
// 假如兔子都不死, 问第n个月的兔子对数为多少?


//  此题关键为看出斐波那契数列
import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           int n = sc.nextInt();
           if (n < 3) {
               System.out.println(1);
               continue;
           }
           int ans = help(n);
           System.out.println(ans);
       }
   }

   private static int help(int n){
       if (n == 1 || n == 2){
           return 1;
       }
       return help(n - 2) + help(n - 1);
   }
}