/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.06
 */
public class Learn_20210406 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1;i <= 5;i++){
            int sc = 1;
            for (int j = 1; j <= i; j++) {
                sc *= j;
            }
        sum += sc;
        }
        System.out.println(sum);
    }

    public static void main9(String[] args) {
        int i = 1;
        int num = 5;
        int sc = 1;
        int sum = 0;
        for (;i <= num;i++){
            sc *= i;
            sum += sc;  //边加边乘
        }
        System.out.println(sum);

    }

    public static void main8(String[] args) {
        //打印是3和5的倍数的数字
        int i = 1;
        while (i <= 100){
            i++;
            if (i % 3 != 0 || i % 5 != 0){
                continue;
            }
            System.out.println(i);
        }

    }

    public static void main7(String[] args) {
        //阶乘累加
        //方法2
        int i = 1;
        int num = 5;
        int sc = 1;
        int sum = 0;
        while (i<=num){
            sc *= i;
            i++;
            sum += sc;  //边加边乘
        }
        System.out.println(sum);
    }

    public static void main6(String[] args) {
        //阶乘累加
        //方法1
        int num = 5;
        int sum = 0;
        int i = 1;
        while (i <= num){
            int fac = 1;
            int j = 1;
            while (j <= i){
                fac *= j;
                j++;
            }
            i++;
            sum += fac;
        }
        System.out.println(sum);
    }

    public static void main5(String[] args) {
        int i = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i < 100) {
            i += 1;
            sum1 += i;
            i += 1;
            sum2 += i;
        }
        System.out.println("奇数和：" + sum1);
        System.out.println("偶数和：" + sum2);
    }

    public static void main4(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);
    }

    public static void main3(String[] args) {
        System.out.println((double) 7.6 % 2);
    }

    public static void main2(String[] args) {
        System.out.println(7 / 2);
        System.out.println((float)7 / 2);
        System.out.println(7 / (float)2);
        System.out.println((float)(7 / 2));
    }

    public static void main1(String[] args) {
        System.out.println(7 + 2);
        System.out.println(7 - 2);
        System.out.println(7 * 2);
        System.out.println(7 / 2);
        System.out.println(7 % 2);
    }
}
