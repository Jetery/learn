/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.07
 */

import java.util.Scanner;
import java.util.Random;

public class Learn_20210408 {

    public static void main(String[] args) {
        //输出一个整数的每一位
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        print(num);
    }

    public static void print(int n) {
        if (n > 9){
            print(n / 10);
        }
        n %= 10;
        System.out.printf("%d ",n);
    }

    public static void main9(String[] args) {
        //输出n*n的乘法口诀表，n由用户输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d  ",i,j,i*j);
            }
            System.out.println();
        }
    }

    public static void main8(String[] args) {
        //多能输入三次密码,密码正确,提示“登录成功”,密码错误,可以重新输入,最多输入三次
        //三次均错,则提示退出程序
        Scanner sc = new Scanner(System.in);
        System.out.println("请设定六位数字密码:");
        int num = sc.nextInt();
        System.out.println("输入密码：");
        for (int i = 0; i < 3; i++) {
            int guess = sc.nextInt();
            if (guess == num){
                System.out.println("登录成功");
                break;
            }
            int count = 2 - i;
            if (i == 2){
                System.out.println("三次机会已用完");
            }else{
                System.out.println("输入错误！还有"+ count + "次机会");
            }
        }
    }

    public static void main7(String[] args) {
        //获取一个数二进制序列中所有的偶数位和奇数位,分别输出二进制序列
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("偶数位:");
        for (int i = 31; i >= 1; i-=2) {
            System.out.printf("%d",(num >> i) & 1);
        }
        System.out.println();
        System.out.println("奇数位:");
        for (int i = 30; i >= 0; i-=2) {
            System.out.printf("%d",(num >> i) & 1);
        }
    }

    public static void main6(String[] args) {
        //求一个整数，在内存当中存储时，二进制1的个数
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int temp = num;
        for (int i = 0; i < 32; i++) {
            num >>= i;
            num &= 1;
            if (num == 1){
                count++;
            }
            num = temp;
        }
        System.out.println(count);
    }

    public static void main5(String[] args) {
        //求两个正整数的最大公约数
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        while (num1 % num2 != 0){
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        System.out.println(num2);
    }

    public static void main4(String[] args){
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100
        double sum = 0;
        for (double i = 1; i < 101; i++) {
            if (i % 2 == 0){
                sum -= 1/i;
            }else{
                sum += 1/i;
            }
        }
        System.out.println(sum);
    }

    public static void main3(String[] args) {
        //猜数字游戏
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess = random.nextInt(100);
        while (true){
            int num = sc.nextInt();
            if (num > guess){
                System.out.println("猜大了");
            }else if (num < guess){
                System.out.println("猜小了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
    }

    public static void main2(String[] args) {
        //求出0～999之间的所有“水仙花数”并输出
        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            int temp = i;
            while (i % 10 >= 0){
                int a = i % 10;
                sum += a*a*a;
                i /= 10;
                if (i == 0){
                    break;
                }
            }
            i = temp;
            if (sum == i){
                System.out.println(sum);
            }
        }
    }

    public static void main1(String[] args) {
        //打印 X 阵型
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if (i == j || i + j == a -1){
                        System.out.print('*');
                    }else{
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }
}
