/*

输入一行，每行空格分割，分别是年，月，日

*/


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] days = new int[]{31, 28, 31, 30,
                               31, 30, 31, 31,
                               30, 31, 30, 31};
        while (sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int ans = help(year);
            for (int i = 0; i < month - 1; i++){
                ans += days[i];
            }
            ans += day;
            //  排除未超过闰年 2 月底的情况
            if (help(year) == 1){
                if (month < 2){
                    ans--;
                } else if (month == 2 && day < 29){
                    ans--;
                }
            }
            System.out.println(ans);
        }
    }
    
    private static int help(int n){
        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0){
            return 1;
        }
        return 0;
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(), month = sc.nextInt(), day = sc.nextInt();
        int[] days = new int[] {31, 28, 31, 30,
                                31, 30, 31, 31,
                                30, 31, 30, 31};
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += days[i];
        }
        if (judge(year) && month > 2)
            ans++;
        ans += day;
        System.out.println(ans);
    }
    
    private static boolean judge(int n) {
        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0)
            return true;
        return false;
    }
}