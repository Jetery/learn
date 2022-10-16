/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.07
 */

import java.util.Scanner;

public class Learn_20210407 {

    public static void main(String[] args) {
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
