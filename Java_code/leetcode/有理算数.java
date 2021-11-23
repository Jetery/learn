/*


链接：https://www.nowcoder.com/questionTerminal/b388bdee5e3e4b1c86a79ad1877a3aa4?from=14pdf
来源：牛客网

对于两个有理数，您的任务是实现基本算术，即计算它们的和、差、积和商。

输入描述：
	每个输入文件包含一个测试用例，它在一行中给出了格式为 “a1/b1 a2/b2” 的两个有理数

	分子和分母都在long int的范围内。如果有负号，它必须只出现在分子前面

	分母保证为非零数


输出描述：
对于每个测试用例，将两个有理数的和、差、积和商分别打印 4 行

每行的格式为“number1 operator number2 = result”

请注意，所有有理数都必须采用最简单的形式“ka/b”

其中 k 是整数部分，而 a/b 是最简单的分数部分

如果数字为负数，则必须包含在一对括号中

如果除法中的分母为零，则输出“Inf”作为结果

保证所有输出整数都在long int范围内


示例1
	输入
		5/3  0/6
	输出
		1 2/3 + 0 = 1 2/3
		1 2/3 - 0 = 1 2/3
		1 2/3 * 0 = 0
		1 2/3 / 0 = Inf

*/

import java.util.Scanner;

public class Main{
   static long a1;
   static long b1;
   static long a2;
   static long b2;
   static String x1;
   static String x2;
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String str = scanner.nextLine();
       // "5 3 0 6"
       String str1 = str.replaceAll("/"," ");
       String[] ch = str1.split(" "); // [5 3 0 6]
       a1 = Integer.parseInt(ch[0]);
       b1 = Integer.parseInt(ch[1]);
       a2 = Integer.parseInt(ch[2]);
       b2 = Integer.parseInt(ch[3]);
       x1 = Number(a1,b1);
       x2 = Number(a2,b2);
       Sum(a1,b1,a2,b2);
       Dif(a1,b1,a2,b2);
       Mul(a1,b1,a2,b2);
       Quo(a1,b1,a2,b2);

   }

   private static void Quo(long a1, long b1, long a2, long b2){
       long tmp = a2;
       a2 = b2;
       b2 = tmp;
       if ("0".equals(x1) ){
           show(x1, "/", x2, "0");
       } else if ("0".equals(x2)) {
           show(x1, "/", x2, "Inf");
       } else if ("1".equals(x1)) {
           show(x1, "/", x2, Number(a2, b2));
       }else if ("1".equals(x2)) {
           show(x1, "/", x2, x1);
       }else {
           long a = a1 * a2;
           long b = b1 * b2;
           String qu = Number(a, b);
           show(x1, "/", x2, qu);
       }

   }

   private static void show(String x, String sign, String y, String z){
       System.out.println(x + " " + sign + " " + y + " " + "=" + " " + z);
   }

   private static String Simple(long x, long y){
       x = Math.abs(x);
       y = Math.abs(y);
       long z = Math.min(x, y);
       while (z>1){
           if (x % z == 0 && y % z == 0) {
               x = x / z;
               y = y / z;
           }
           z--;
       }
       return x + "/" + y;
   }

   private static String Number(long x, long y){
       if(x == 0) {
           return "0";
       } else if((x > 0 && y > 0) || (x < 0 && y < 0)){
           if (x % y == 0) {
               return Math.abs(x / y) + "";
           }else if(x == y){
               return 1 + "";
           }else if (Math.abs(x) >Math.abs(y)) {
               return Math.abs(x / y) + " " + Simple(x % y, y);
           }else if (Math.abs(x) < Math.abs(y)) {
               return Simple(x % y,y);
           }
       }else if (x < 0 && y > 0){
           if (x%y == 0) {
               return "(" + "-" + Math.abs(x / y) + ")";
           }else if(Math.abs(x) == y){
               return -1 + "";
           }else if (Math.abs(x) > y) {
               return "(" + x / y + " " + Simple(x % y, y) + ")";
           }else if (Math.abs(x) < y) {
               return "(" + "-"+Simple(x % y, y)+ ")";
           }
       }else if (x > 0 && y < 0) {
           if (x % y == 0) {
               return "(" + "-" + Math.abs(x / y) + ")";
           }else if(x == Math.abs(y)){
               return -1 + "";
           }else if (x > Math.abs(y)) {
               return "(" + "-" + Math.abs(x / y) + " " + Simple(x % y, y) + ")";
           }else if (x < Math.abs(y)) {
               return "(" + "-" + Simple(x % y, y)+ ")";
           }
       }
       return null;
   }


   private static void Sum(long a1, long b1, long a2, long b2){
       if ("0".equals(x1)) {
           show(x1,"+",x2, x2);
       }else if ("0".equals(x2)) {
           show(x1,"+",x2, x1);
       }else {
           long a = a1 * b2 + b1 * a2;
           long b = b1 * b2;
           String sum = Number(a, b);
           show(x1,"+", x2, sum);
       }
   }

   private static void Dif(long a1, long b1, long a2, long b2){
       a2 = -a2;
       if ("0".equals(x1)) {
           show(x1, "-", x2, Number(a2, b2));
       }else if ("0".equals(x2)) {
           show(x1,"-", x2, x1);
       }else {
           long a = a1 * b2 + b1 * a2;
           long b = b1 * b2;
           String sum = Number(a, b);
           show(x1,"-", x2, sum);
       }
   }

   private static void Mul(long a1, long b1, long a2, long b2){
       if ("0".equals(x1) || "0".equals(x2)){
           show(x1,"*",x2,"0");
       } else if ("1".equals(x1)) {
           show(x1, "*", x2, x2);
       }else if ("1".equals(x2)) {
           show(x1, "*", x2, x1);
       }else {
           long a = a1 * a2;
           long b = b1 * b2;
           String mul = Number(a, b);
           show(x1, "*", x2, mul);
       }
   }
}
