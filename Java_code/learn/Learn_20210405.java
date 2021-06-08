/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.04
 */
import java.util.Scanner;

public class Learn_20210405 {
    public static void main(String[] args) {
        //根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int age = sc.nextInt();
        if (age <= 18 && age > 0){
            System.out.println("少年");
        }else if (19 <= age && age <= 28){
            System.out.println("青年");
        }else if (29 <= age && age <= 55){
            System.out.println("中年");
        }else if (age >= 56){
            System.out.println("老年");
        }
    }

    public static void main1(String[] args) {
        //给定一个数字，判定一个数字是否是素数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i ==0) {
                flag = true;
                break;
            }
        }
        if (flag == true){
            System.out.println("该数不是素数");
        }else {
            System.out.println("该数是素数");
        }
    }
}
