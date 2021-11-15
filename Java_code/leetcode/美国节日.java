/*

 和中国的节日不同，美国的节假日通常是选择某个月的第几个星期几这种形式，因此每一年的放假日期都不相同。具体规则如下：
* 1月1日：元旦
* 1月的第三个星期一：马丁·路德·金纪念日
* 2月的第三个星期一：总统节
* 5月的最后一个星期一：阵亡将士纪念日
* 7月4日：美国国庆
* 9月的第一个星期一：劳动节
* 11月的第四个星期四：感恩节
* 12月25日：圣诞节
现在给出一个年份，请你帮忙生成当年节日的日期。

输入描述:

	输入包含多组数据，每组数据包含一个正整数year（2000≤year≤9999）。

*/


//  重点考察蔡勒公式
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            show(year);
        }
    }
    private static int demandOfWeek(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int century = year / 100;
        year %= 100;
        int week = (century / 4 - 2 * century + year + year / 4 + (13 * (month + 1)) / 5);
        week = (week % 7 + 7) % 7;
        if (week == 0) {
            week = 7;
        }
        return week;
    }


    private static int demandOfDay(int year, int month, int count, int num){
        int week = demandOfWeek(year, month, 1);
        int day = (count - 1) * 7 + (num + 7 - week) % 7 + 1;
        return day;
    }


    private static void festival (int year) {
        String log = String.format("%d-01-01", year);
        System.out.println(log);
    }


    private static void mading(int year) {
        int day = demandOfDay(year, 1, 3, 1);
        String log = String.format("%d-01-%02d", year, day);
        System.out.println(log);
    }

    private static void present(int year) {
        int day = demandOfDay(year, 2, 3, 1);
        String log = String.format("%d-02-%02d", year, day);
        System.out.println(log);
    }

    private static void die (int year) {
        int help = demandOfWeek(year, 6, 1);
        int day = 31 - ((help == 1) ? 6 : (help - 2));
        String log = String.format("%d-05-%02d", year, day);
        System.out.println(log);
    }

    private static void usa(int year) {
        String log = String.format("%d-07-04", year);
        System.out.println(log);
    }

    private static void workDay(int year) {
        int day = demandOfDay(year, 9, 1, 1);
        String log = String.format("%d-09-%02d", year, day);
        System.out.println(log);
    }

    private static void thanksGiving(int year) {
        int day = demandOfDay(year, 11, 4, 4);
        String log = String.format("%d-11-%02d", year, day);
        System.out.println(log);
    }

    private static void christmas(int year) {
        String log = String.format("%d-12-25", year);
        System.out.println(log);
    }
    private static void show(int year) {
        festival(year);
        mading(year);
        present(year);
        die(year);
        usa(year);
        workDay(year);
        thanksGiving(year);
        christmas(year);
        System.out.println();
    }
}