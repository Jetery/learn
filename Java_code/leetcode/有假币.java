/*

居然有假币！ 现在猪肉涨了，但是农民的工资却不见涨啊，没钱怎么买猪肉啊。

nowcoder这就去买猪肉，结果找来的零钱中有假币！！！

可惜nowcoder 一不小心把它混进了一堆真币里面去了。

只知道假币的重量比真币的质量要轻，给你一个天平（天平两端能容纳无限个硬币），请用最快的时间把那个可恶的假币找出来。 


输入描述:
	1≤n≤2^30,输入0结束程序。



输出描述:
	最多要称几次一定能把那个假币找出来？

*/

/*
  每次分三堆
  若不能平均分:
  		1. 剩余 1 个 
  			分成 1/3 & 1/3 & 1 + (1/3)
  			两个1/3放入天平两端，
  		2. 剩余 2 个
  			分成 1/3 & 1 + (1/3) & 1 + (1/3)
  			两个1 + (1/3)放入天平两端

  	由于题目要求最快的时间  并且是求最多的次数  都考虑最坏情况  因此取每次剩余的最大值 1 + (1/3)
*/
import java.util.*;
public class Main {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           int num = sc.nextInt();
           if (num == 0){
               return;
           }
           int ans = 0;
           while (num > 1){
               ans++;
               if (num % 3 != 0){
                   num = num / 3 + 1;
               } else {
                   num /= 3;
               }
           }
           System.out.println(ans);
       }
   }
}
