/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.11
 */

import java.util.Scanner;

public class Learn_20210411 {

    /**
     * pos1 -> begin
     * pos2 -> switch
     * pos3 -> purpose
     */
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }

    public static void move(char pos1,char pos2){
        System.out.print(pos1 + " -> " + pos2 + "  ");
    }

    public static void hanoi(int n,char pos1,char pos2,char pos3){
        if (n == 1){
            move(pos1,pos3);
        } else {
            hanoi(n - 1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanoi(n - 1, pos2, pos1, pos3);
        }
    }


    public static int fac(int n){
        if (n == 1){
            return n;
        }
        return n * fac(n - 1);
    }

    public static void main6(String[] args) {
        //递归求 N 的阶乘
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(fac(n));
    }


    public static int add(int n){
        if (n == 1)
        {
            return n;
        }
        return n + add(n - 1);
    }

    public static void main5(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        int n = 10;
        System.out.println(add(n));
    }


    public static void print(int n){
        if (n > 9) {
            print(n / 10);
        }
        System.out.print(n % 10 + " ");
    }

    public static void main4(String[] args) {
        //按顺序打印一个数字的每一位
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }


    public static int sum(int n){
        if (n > 9){
            return n % 10 + sum(n / 10);
        }
        return n;
    }

    public static void main3(String[] args){
        //写一个递归方法，输入一个非负整数，返回组成它的数字之和
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum(n));
    }

    public static int fib(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n -1) + fib(n - 2);
    }

    public static void main2(String[] args){
        //递归求斐波那契数列的第 N 项
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    public static int jumpFloor(int n){
        if (n == 1 || n == 2){
            return n;
        }
        return jumpFloor(n - 1) + jumpFloor(n - 2);
    }

    public static void main1(String[] args){
        //青蛙跳台阶问题
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jumpFloor(n));
    }

}
