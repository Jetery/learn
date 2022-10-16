/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.10
 */

import java.util.Scanner;

public class Learn_20210410 {

    public static void main(String[] args){
        //求最大值
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        // 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        int a = 10;
        int b = 20;
        int c = 30;
        int maxNum = max3(a,b,c);
        System.out.println(maxNum);
    }

    public static int max3(int a,int b,int c){
        int max = max2(a,b);
        int ret = max2(max,c);
        return ret;
    }

    public static int max2(int a,int b){
        return a > b ? a : b;
    }


    public static void main2(String[] args){
        //求1！+2！+3！+4！+........+n!的和
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = sum(n);
        System.out.println(ret);
    }

    public static int sum(int n){
        int ret = 0;
        for (int i = n; i > 0; i--){
            ret += fac(i);
        }
        return ret;
    }

    public static int fac(int n){
        int ret = 1;
        for (int i = n; i > 0; i--){
            ret *= i;
        }
        return ret;
    }

    public static void main1(String[] args) {
        //求斐波那契数列的第n项。(迭代实现)
        Scanner sc = new Scanner(System.in);
        System.out.println("求斐波那契数列第几项：");
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(a);
    }
}
