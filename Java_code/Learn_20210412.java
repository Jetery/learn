/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.12
 */

import java.util.Scanner;


public class Learn_20210412 {


    public int JumpFloorII(int target) {
        int sum = 1;
        if(target == 0)
            return 0;
        for(int i = 1;i < target; i++)
            sum = 2* sum;
        return sum;
    }


    public static int jumpFloor(int target) {
        return 1<<(target-1);
        //return (int)Math.pow(2,target-1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jumpFloor(n));
    }

}
